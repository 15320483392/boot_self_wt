package com.example.boot_self_wt.common.utils.jwt;

/**
 * Created by ace on 2017/9/10.
 */
public interface IJWTInfo {
    /**
     * 获取登录名
     * @return
     */
    String getLoginName();

    /**
     * 获取用户ID
     * @return
     */
    String getId();

    /**
     * 获取用户姓名
     * @return
     */
    String getStaffName();

    /**
     * 获取租户ID
     * @return
     */
    String getTenantId();
}
