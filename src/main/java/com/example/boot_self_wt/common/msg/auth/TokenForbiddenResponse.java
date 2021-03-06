package com.example.boot_self_wt.common.msg.auth;

import com.example.boot_self_wt.common.constant.RestCodeConstants;
import com.example.boot_self_wt.common.msg.BaseResponse;

public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
