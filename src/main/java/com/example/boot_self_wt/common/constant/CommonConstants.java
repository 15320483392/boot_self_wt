package com.example.boot_self_wt.common.constant;

/**
 * Created by ace on 2017/8/29.
 */
public class CommonConstants {
    public final static String RESOURCE_TYPE_MENU = "menu";
    public final static String RESOURCE_TYPE_BTN = "button";
    //用户无权限
    public static final Integer EX_PERMISSION_INVALID_CODE = 40311;
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40101;
    // 客户端token过期异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40301;

    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;
    public static final String CONTEXT_KEY_STAFF_ID = "currentStaffId";
    public static final String CONTEXT_KEY_LOGIN_NAME = "currentLoginName";
    public static final String CONTEXT_KEY_TENANTID = "currentTenantId";
    public static final String CONTEXT_KEY_STAFF_NAME = "currentStaffName";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
    public static final String JWT_KEY_TENANT_ID = "tenantId";

    //将账号保存在Redis的key
    public static final String REDIS_KEY = "loginMsg";

    //Redis 过期时限
    public static final long TOKEN_OVERTIME = 14400*1000;
}
