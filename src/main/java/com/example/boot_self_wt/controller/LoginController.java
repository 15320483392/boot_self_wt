package com.example.boot_self_wt.controller;

import com.example.boot_self_wt.common.msg.ObjectRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangtao
 * @date 2018/9/10 18:01
 */
@Controller
@RequestMapping("login")
@Api(description = "登陆接口", tags = {"LoginController"})
public class LoginController {
    @ApiOperation(value = "登录")
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse createOrUpdateTaskGroup () {
        System.out.println("登陆");
        return new ObjectRestResponse<>().msg("操作成功!").rel(true);
    }
}
