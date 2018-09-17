package com.example.boot_self_wt.common.filter;

import com.example.boot_self_wt.common.utils.RedisUtils;
import com.example.boot_self_wt.common.utils.jwt.IJWTInfo;
import com.example.boot_self_wt.common.utils.user.JwtTokenUtil;
import com.example.boot_self_wt.config.UserAuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证token
 * @author wangtao
 * @date 2018/9/11 9:12
 * @param  * @param null
 * @return
 */
public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(userAuthConfig.getTokenHeader());
        if (token != null) {
            //验证token
            IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(token);
            //获取登陆账号
            String uniqueName = infoFromToken.getLoginName();
            //验证账号是否登录
            if(redisUtils.VerificationLogin(uniqueName)){
                return super.preHandle(request, response, handler);
            }
        }
        throw new ClientForbiddenException("Client is Forbidden This token anomaly!");
    }
}
