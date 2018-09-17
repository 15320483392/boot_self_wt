package com.example.boot_self_wt.service;

import com.example.boot_self_wt.common.msg.ObjectRestResponse;

import java.util.List;

/**
 * Created by ace on 2017/9/15.
 */
public interface ClientService {

    ObjectRestResponse<List<String>> getAllowedClient( String serviceId, String secret);

    ObjectRestResponse getAccessToken( String clientId, String secret);

    ObjectRestResponse<byte[]> getServicePublicKey(String clientId, String secret);

    ObjectRestResponse<byte[]> getUserPublicKey( String clientId,  String secret);

}
