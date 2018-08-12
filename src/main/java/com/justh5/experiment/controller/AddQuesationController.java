package com.justh5.experiment.controller;

import com.justh5.experiment.domain.SysResult;
import com.justh5.experiment.model.questionBank.QuestionModel;
import com.justh5.experiment.service.QuestionSercice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/question")
public class AddQuesationController {
    private Logger logger = LoggerFactory.getLogger(AddQuesationController.class);
    @Autowired
    QuestionSercice questionSercice;

    /**
     * 新增题库
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addQuestions")
    public SysResult addQuestion(HttpServletRequest request) {
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        String answer3 = request.getParameter("answer3");
        String quesType = request.getParameter("quesType");
        String keyPoint = request.getParameter("keyPoint");
        String subject = request.getParameter("subject");
        SysResult sysResult = new SysResult();
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestion(question);
        questionModel.setAnswer(answer);
        questionModel.setAnswer1(answer1);
        questionModel.setAnswer2(answer2);
        questionModel.setAnswer3(answer3);
        questionModel.setQuesType(quesType);
        questionModel.setKeyPoint(keyPoint);
        questionModel.setSubject(subject);
        questionSercice.addQuestion(questionModel);
        return new SysResult(0, "新增成功");
    }
    @CrossOrigin
    @RequestMapping(value = "/add")
    public Object jumpToView1(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        modelAndView.setViewName("admin/addQuestion");
        return modelAndView;
    }
}