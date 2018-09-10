package com.example.boot_self_wt.common.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Ace on 2017/6/11.
 */
@ApiModel(value="ObjectRestResponse",description="接口返回数据")
public class ObjectRestResponse<T> extends BaseResponse {

    @ApiModelProperty(name="data",value="返回数据")
    T data;

    @ApiModelProperty(name="rel",value="true:操作成功,false:操作失败")
    boolean rel;

    @ApiModelProperty(name="msg",value="提示信息")
    String msg;

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }


    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ObjectRestResponse msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
