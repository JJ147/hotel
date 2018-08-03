package com.justh5.experiment.service;

import com.justh5.experiment.model.StudentRegisterModel;

public interface RegisterService {
    /**
     * 注册
     * @param studentRegisterModel
     * @return
     * @athor:jibingfeng
     */
//    int InsertStudent(StudentRegisterModel studentRegisterModel);
     Integer addStudent(StudentRegisterModel studentRegisterModel);

    /**
     * 注册时匹配数据库，查看是否数据库已有账号
     * @param stuId
     * @return
     */
     StudentRegisterModel getStudentById(Integer stuId);

    int registerStudent(StudentRegisterModel studentRegisterModel);
}
