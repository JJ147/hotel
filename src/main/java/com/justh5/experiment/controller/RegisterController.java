package com.justh5.experiment.controller;

import com.justh5.experiment.domain.ResponseBean;
import com.justh5.experiment.domain.SysResult;
import com.justh5.experiment.model.StudentRegisterModel;
import com.justh5.experiment.service.RegisterService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/student")
public class RegisterController {
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    RegisterService registerService;

    @ResponseBody
    @RequestMapping(value = "/regist")
    public SysResult getStudentMsg( StudentRegisterModel studentRegisterModel) {
        if(StringUtils.isBlank(studentRegisterModel.getStuName())){
            return new SysResult(0,"名称不能为空");
        }
        if (StringUtils.isBlank(studentRegisterModel.getStuPwd())){
            return new SysResult(0,"学生密码不能为空");
        }
        if (StringUtils.isBlank(studentRegisterModel.getGrade())){
            return new SysResult(0,"年级不能为空");
        }
        if(StringUtils.isBlank(studentRegisterModel.getStuSex())){
            return new SysResult(0,"学生性别不能为空");
        }
        if (StringUtils.isBlank(studentRegisterModel.getMyClass())){
            return new SysResult(0,"班级不能为空");
        }
        if (StringUtils.isBlank(studentRegisterModel.getAcademy())){
            return new SysResult(0,"学院不能为空");
        }
        if (StringUtils.isBlank(studentRegisterModel.getProfessional())){
            return new SysResult(0,"专业不能为空");
        }
            registerService.registerStudent(studentRegisterModel);
        return new SysResult(1, "注册成功");
    }
}
