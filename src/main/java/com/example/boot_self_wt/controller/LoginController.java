package com.example.boot_self_wt.controller;

import com.example.boot_self_wt.common.utils.user.JwtAuthenticationRequest;
import com.example.boot_self_wt.common.utils.user.JwtAuthenticationResponse;
import com.example.boot_self_wt.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangtao
 * @date 2018/9/10 18:01
 */
@Controller
@RequestMapping("login")
@Api(description = "登陆接口", tags = {"LoginController"})
public class LoginController {

    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> userLoginCreateToken (@RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        //验证用户成功返回token
        final String token = loginService.login(authenticationRequest);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshUserLoginToken(
            HttpServletRequest request) {
        //获取请求头中的token
        String token = request.getHeader(tokenHeader);
        //刷新token
        String refreshedToken = null;
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }
}
