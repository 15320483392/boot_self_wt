package com.example.boot_self_wt.service.Impl;

import com.example.boot_self_wt.common.msg.ObjectRestResponse;
import com.example.boot_self_wt.common.server.KeyConfiguration;
import com.example.boot_self_wt.service.AuthClientService;
import com.example.boot_self_wt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WTar
 * @date 2018/9/12 15:33
 */
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private AuthClientService authClientService;
    @Autowired
    private KeyConfiguration keyConfiguration;

    public ObjectRestResponse getAccessToken(String clientId, String secret) {
        String da = null;
        try {
            da = authClientService.apply(clientId, secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ObjectRestResponse<String>().data(da);
    }

    public ObjectRestResponse getAllowedClient(String serviceId, String secret) {
        return new ObjectRestResponse<List<String>>().data(authClientService.getAllowedClient(serviceId, secret));
    }

    public ObjectRestResponse<byte[]> getServicePublicKey(String clientId, String secret) {
        try {
            authClientService.validate(clientId, secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ObjectRestResponse<byte[]>().data(keyConfiguration.getServicePubKey());
    }

    public ObjectRestResponse<byte[]> getUserPublicKey(String clientId,  String secret) {
        try {
            authClientService.validate(clientId, secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ObjectRestResponse<byte[]>().data(keyConfiguration.getUserPubKey());
    }

}
