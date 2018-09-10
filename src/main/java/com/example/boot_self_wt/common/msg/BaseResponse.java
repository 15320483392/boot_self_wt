package com.example.boot_self_wt.common.msg;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ace on 2017/8/23.
 */
public class BaseResponse {

    @ApiModelProperty(name="status",value="请求返回编码")
    private int status = 200;

    @ApiModelProperty(name="data",value="请求提示信息")
    private String message;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
