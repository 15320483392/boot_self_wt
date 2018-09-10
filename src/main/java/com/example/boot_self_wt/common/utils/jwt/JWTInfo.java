package com.example.boot_self_wt.common.utils.jwt;

import java.io.Serializable;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTInfo implements Serializable,IJWTInfo {
    private String loginName;
    private String userId;
    private String staffName;



    private String tenantId;



    public JWTInfo(String loginName, String userId, String staffName,String tenantId) {
        this.loginName = loginName;
        this.userId = userId;
        this.staffName = staffName;
        this.tenantId = tenantId;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String getId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JWTInfo jwtInfo = (JWTInfo) o;

        if (loginName != null ? !loginName.equals(jwtInfo.loginName) : jwtInfo.loginName != null) {
            return false;
        }
        return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;

    }

    @Override
    public int hashCode() {
        int result = loginName != null ? loginName.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
