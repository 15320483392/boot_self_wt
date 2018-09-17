package com.example.boot_self_wt.common.msg.auth;

import com.example.boot_self_wt.common.constant.RestCodeConstants;
import com.example.boot_self_wt.common.msg.BaseResponse;

public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
