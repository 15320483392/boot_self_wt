package com.example.boot_self_wt.common.exception.permission;

import com.example.boot_self_wt.common.constant.CommonConstants;
import com.example.boot_self_wt.common.exception.BaseException;

/**
 * Created by dongl on 2018/7/5.
 */
public class PermissionException  extends BaseException {
    public PermissionException(String message) {
        super(message, CommonConstants.EX_PERMISSION_INVALID_CODE);
    }
}
