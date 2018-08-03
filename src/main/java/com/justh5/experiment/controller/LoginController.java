package com.justh5.experiment.controller;

import com.justh5.experiment.domain.SysResult;
import com.justh5.experiment.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @ResponseBody
    @RequestMapping(value = "/student")
    public SysResult stuLogin(HttpServletRequest request){
        String loginName = request.getParameter("loginName");
        String pwd = request.getParameter("pwd");
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(pwd)){
            return new SysResult(0,"名称不能为空");
        }
        if (loginService.studentLogin(loginName,pwd)){
            return new SysResult(1,"--");
        }
        return new SysResult(1,"登陆成功");
    }
    @ResponseBody
    @RequestMapping(value = "/studentLogin")
    public String login(HttpServletRequest request,HttpServletResponse response){
        return "html/login.html";
    }
}
