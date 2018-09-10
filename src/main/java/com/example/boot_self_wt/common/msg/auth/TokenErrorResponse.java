package com.example.boot_self_wt.common.msg.auth;

import com.example.boot_self_wt.common.constant.RestCodeConstants;
import com.example.boot_self_wt.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/23.
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
