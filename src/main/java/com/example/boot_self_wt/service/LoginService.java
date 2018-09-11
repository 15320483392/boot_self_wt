package com.example.boot_self_wt.service;

import com.example.boot_self_wt.common.utils.user.JwtAuthenticationRequest;

/**
 * @author WTar
 * @date 2018/9/11 9:32
 */
public interface LoginService {
    //用户登录
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;

    boolean vcnUser (String loginName);

    void addLogUser(String loginName,String passWord);
}
