package com.example.boot_self_wt.service.Impl;

import com.example.boot_self_wt.common.utils.jwt.JWTInfo;
import com.example.boot_self_wt.common.utils.user.JwtAuthenticationRequest;
import com.example.boot_self_wt.common.utils.user.JwtTokenUtil;
import com.example.boot_self_wt.entity.User;
import com.example.boot_self_wt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author WTar
 * @date 2018/9/11 9:33
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
        User user = validate(users.getLoginName(),users.getPassword());
        //用户是否存在
        if (!StringUtils.isEmpty(user.getUserId())) {
            //生成token
            token = jwtTokenUtil.generateToken(new JWTInfo(user.getLoginName(),  user.getUserId(), user.getName(),"wt"));
        }
        return token;
    }

    private User validate (String loginName, String password) {
        System.out.println("登录名" + loginName + ";密码" + password);
        User user = new User();
        user.setName("管理员");
        user.setUserId("1");
        user.setLoginName(loginName);
        //查询用户

        //是否存在
        if (!"admin".equals(loginName)) {
            throw new RuntimeException("用户名或密码错误！");
        }
        //验证密码
        /*if (encoder.matches(password,user.getPassWord())) {
            user.setName("管理员");
            user.setUserId("1");
            user.setLoginName(loginName);
        }else {
            throw new RuntimeException("用户名或密码错误！");
        }*/
        return user;
    }
}
