package com.justh5.experiment.model;

public class LoginModel {
    /**
     * 登陆名
     */
    private String loginName;
    /**
     *
     * 登陆密码
     */
    private String pwd;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "loginName='" + loginName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
