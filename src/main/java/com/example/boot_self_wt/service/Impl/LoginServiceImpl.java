package com.example.boot_self_wt.service.Impl;

import com.example.boot_self_wt.common.utils.RedisUtils;
import com.example.boot_self_wt.common.utils.jwt.JWTInfo;
import com.example.boot_self_wt.common.utils.user.JwtAuthenticationRequest;
import com.example.boot_self_wt.common.utils.user.JwtTokenUtil;
import com.example.boot_self_wt.domain.dao.LoginMapper;
import com.example.boot_self_wt.domain.entity.Login;
import com.example.boot_self_wt.service.LoginService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author WTar
 * @date 2018/9/11 9:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RedisUtils redisUtils;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    /**
     * 用户登录
     * @author wangtao
     * @date 2018/9/11 9:35
     * @param  * @param authenticationRequest
     * @return java.lang.String
     */
    @Override
    public String login(JwtAuthenticationRequest users) throws Exception {
        String token = "";
        //验证账号密码
        Login user = validate(users.getLoginName(),users.getPassword());
        //用户是否存在
        if (!StringUtils.isEmpty(user.getUserId())) {
            //生成token
            token = jwtTokenUtil.generateToken(new JWTInfo(user.getLoginName(),  user.getUserId() + "", user.getName(),"wt"));
            redisUtils.addRedisLogin(users.getLoginName());
        }
        return token;
    }



    @Override
    public boolean vcnUser(String loginName) {
        //查询用户
        Login login = sqlSession.selectOne("com.example.login.getLonginByLoginName",loginName);
        if (login.getId() != null) {
            return true;
        }
        return false;
    }

    @Override
    public void addLogUser(String loginName, String passWord) {
        Login login = new Login();
        login.setLoginName(loginName);
        login.setName("游客");
        login.setUserId(2);
        login.setPassword(passWord);
        login.setGroup("1");
        loginMapper.insert(login);
    }

    /**
     * 验证用户是否存在
     * @author wangtao
     * @date 2018/9/11 15:47
     * @param  * @param loginName
     * @param password
     * @return com.example.boot_self_wt.entity.Login
     */
    private Login validate (String loginName, String password) {
        System.out.println("登录名" + loginName + ";密码" + password);
        //查询用户
        Login login = sqlSession.selectOne("org.common.login.getLonginByLoginName",loginName);
        //是否存在
        if (login == null || "".equals(login.getId())) {
            throw new RuntimeException("用户名或密码错误！");
        }
        //验证密码
        if (!encoder.matches(password,login.getPassword())) {
            throw new RuntimeException("用户名或密码错误！");
        }
        return login;
    }
}
