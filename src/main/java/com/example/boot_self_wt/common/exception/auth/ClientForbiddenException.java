package com.example.boot_self_wt.common.exception.auth;


import com.example.boot_self_wt.common.constant.CommonConstants;
import com.example.boot_self_wt.common.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
