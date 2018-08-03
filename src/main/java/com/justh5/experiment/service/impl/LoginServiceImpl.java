package com.justh5.experiment.service.impl;

import com.justh5.experiment.mapper.StudentDao;
import com.justh5.experiment.model.LoginModel;
import com.justh5.experiment.model.StudentRegisterModel;
import com.justh5.experiment.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    StudentDao studentDao;
    @Override
    public boolean studentLogin(String loginname,String pwd ) {
        LoginModel loginModel1 = new LoginModel();
        loginModel1.setLoginName(loginname);
        loginModel1.setPwd(pwd);
        StudentRegisterModel model = studentDao.studentLogin(loginModel1);
        if (model == null){
            return false;
        }
        return true;
    }
}
