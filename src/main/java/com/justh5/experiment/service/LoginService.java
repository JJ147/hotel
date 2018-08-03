package com.justh5.experiment.service;

import com.justh5.experiment.model.LoginModel;
import com.justh5.experiment.model.StudentRegisterModel;

public interface LoginService {
    /**
     * 学生登陆/
     * 判断学生是否登陆
     * @return
     */
    boolean studentLogin(String loginname,String pwd);
}
