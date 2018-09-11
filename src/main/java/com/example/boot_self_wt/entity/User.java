package com.example.boot_self_wt.entity;

/**
 * @author WTar
 * @date 2018/9/11 10:19
 */
public class User {
    private String userId;
    private String name;
    private String loginName;
    private String passWord;

    public User() {
    }

    public User(String userId, String name, String loginName, String passWord) {
        this.userId = userId;
        this.name = name;
        this.loginName = loginName;
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        final StringBuilder model = new StringBuilder("{");
        model.append("\"userId\":\"").append(userId).append('\"');
        model.append(",\"name\":\"").append(name).append('\"');
        model.append(",\"loginName\":\"").append(loginName).append('\"');
        model.append(",\"passWord\":\"").append(passWord).append('\"');
        model.append('}');
        return model.toString();
    }
}
