package com.example.boot_self_wt.common.filter;

import com.example.boot_self_wt.common.context.BaseContextHandler;
import com.example.boot_self_wt.common.utils.jwt.IJWTInfo;
import com.example.boot_self_wt.common.utils.user.JwtTokenUtil;
import com.example.boot_self_wt.config.UserAuthConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证登录用户
 * Created by ace on 2017/9/10.
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(userAuthConfig.getTokenHeader());
        if (StringUtils.isEmpty(token)) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(userAuthConfig.getTokenHeader())) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(token);
        BaseContextHandler.setLoginName(infoFromToken.getLoginName());
        BaseContextHandler.setStaffName(infoFromToken.getStaffName());
        BaseContextHandler.setStaffID(infoFromToken.getId());
        BaseContextHandler.setTenantId(infoFromToken.getTenantId());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
