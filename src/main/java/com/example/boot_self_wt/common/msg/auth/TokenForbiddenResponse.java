package com.example.boot_self_wt.common.msg.auth;

import com.example.boot_self_wt.common.constant.RestCodeConstants;
import com.example.boot_self_wt.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/25.
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
