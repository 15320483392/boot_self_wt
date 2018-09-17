package com.example.boot_self_wt.domain.entity;

/**
 * @author wangtao
 * @date 2018/9/17 15:23
 */
public class RedisLogin {
    private String loginName;
    private long times;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    @Override
    public String toString() {
        final StringBuilder model = new StringBuilder("{");
        model.append("\"loginName\":\"").append(loginName).append('\"');
        model.append(",\"times\":").append(times);
        model.append('}');
        return model.toString();
    }
}
