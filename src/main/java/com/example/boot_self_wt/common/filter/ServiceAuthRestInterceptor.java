package com.example.boot_self_wt.common.filter;

import com.example.boot_self_wt.common.utils.jwt.IJWTInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        //验证token
        IJWTInfo infoFromToken = null;
        //获取登陆账号
        String uniqueName = ""; //infoFromToken.getLoginName();
        if ("".equals(uniqueName)) {
            return super.preHandle(request, response, handler);
        }
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
