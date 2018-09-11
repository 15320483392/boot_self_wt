package com.example.boot_self_wt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WTar
 * @date 2018/9/11 11:50
 */
@Controller
@RequestMapping("userm")
public class UserMessageController {

    @RequestMapping(value = "tes", method = RequestMethod.POST)
    @ResponseBody
    public void test(){

    }
}
