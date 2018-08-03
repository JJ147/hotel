package com.justh5.experiment.service.impl;

import com.justh5.experiment.dao.HotellDao;
import com.justh5.experiment.mapper.StudentDao;
import com.justh5.experiment.model.StudentRegisterModel;
import com.justh5.experiment.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("RegisterService")
public class RegisterServiceImpl implements RegisterService {

    @Resource
    HotellDao hotellDao;
    @Resource
    StudentDao studentDao;
    /**
     * 注册
     * @param studentRegisterModel
     * @return
     * @athor：jibingfeng
     * @time：2018/7/25
     */
    @Override
    public Integer addStudent(StudentRegisterModel studentRegisterModel) {
        return hotellDao.addStudent(studentRegisterModel);
    }

    /**
     * 查看是否已注册
     * @param stuId
     * @return
     */
    @Override
    public StudentRegisterModel getStudentById(Integer stuId) {
        return hotellDao.getStudentById(stuId);
    }

    @Override
    public int registerStudent(StudentRegisterModel studentRegisterModel) {
        return studentDao.registerStudent(studentRegisterModel);
    }
}
