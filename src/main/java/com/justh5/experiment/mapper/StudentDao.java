package com.justh5.experiment.mapper;

import com.justh5.experiment.model.LoginModel;
import com.justh5.experiment.model.StudentRegisterModel;

public interface StudentDao {
    /**
     * 注册学生信息
     * @param studentRegisterModel
     * @return
     */
    int registerStudent(StudentRegisterModel studentRegisterModel);

    /**
     * 学生登陆
     * @param loginModel
     * @return
     */
    StudentRegisterModel studentLogin(LoginModel loginModel);
}
