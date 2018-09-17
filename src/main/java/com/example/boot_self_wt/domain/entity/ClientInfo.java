package com.example.boot_self_wt.domain.entity;


import com.example.boot_self_wt.common.utils.jwt.IJWTInfo;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientInfo implements IJWTInfo {
    String clientId;
    String name;

    public ClientInfo(String clientId, String name, String id) {
        this.clientId = clientId;
        this.name = name;
        this.id = id;
    }



    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    String tenantId;
    public void setId(String id) {
        this.id = id;
    }

    String id;
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLoginName() {
        return clientId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getStaffName() {
        return name;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }
}
