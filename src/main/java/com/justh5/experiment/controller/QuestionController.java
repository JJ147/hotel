package com.justh5.experiment.controller;

import com.alibaba.fastjson.JSON;
import com.justh5.experiment.domain.ResponseBean;
import com.justh5.experiment.domain.SysResult;
import com.justh5.experiment.function.ResponseFunction;
import com.justh5.experiment.model.questionBank.QuestionModel;
import com.justh5.experiment.model.questionBank.QuestionQueryModel;
import com.justh5.experiment.service.QuestionSercice;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
    private Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    QuestionSercice questionSercice;

    public QuestionQueryModel getQueryModel(HttpServletRequest request){
        QuestionQueryModel questionQueryModel = new QuestionQueryModel();
        if (request.getParameter("quesId") != null && !"".equals(request.getParameter("quesId"))){
            questionQueryModel.setQuesId(Integer.parseInt(request.getParameter("quesId")));
        }
        if (request.getParameter("quesType") != null && !"".equals(request.getParameter("quesType"))){
            questionQueryModel.setQuesType(request.getParameter("quesType"));
        }
        if (request.getParameter("subject") != null && !"".equals(request.getParameter("subject"))){
            questionQueryModel.setSubject(request.getParameter("subject"));
        }
        return questionQueryModel;
    }

    /**
     * 查询题库
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryQuestion")
    public SysResult getQuestionMsg (HttpServletRequest request){
        logger.info("请求开始getQuestionMsg");
        QuestionQueryModel questionQueryModel = getQueryModel(request);
        List<QuestionModel> qusetionList = questionSercice.getQuestionMsg(questionQueryModel);
        return new SysResult(0,"查询成功",qusetionList);
    }

    @ResponseBody
    @RequestMapping(value = "queryQuestionJsonp")
    public String getQuestionMsgJsonp (HttpServletRequest request){
        logger.info("请求开始getQuestionMsg");
        QuestionQueryModel questionQueryModel = getQueryModel(request);
        String callback = request.getParameter("callback");
        List<QuestionModel> qusetionList = questionSercice.getQuestionMsg(questionQueryModel);
        String result = callback+"("+JSON.toJSONString(new SysResult(0,"查询成功",qusetionList))+")";
        return result;
    }


    /**
     * 更新题库
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateQuestion")
    public SysResult updateQuestion(HttpServletRequest request){
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
        questionSercice.updateQuestion(questionModel);
        return new SysResult(0,"修改题目成功");
    }

    /**
     * 删除题目
     * @param questionQueryModel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteQueestion")
    public SysResult deleteQueestionByid(QuestionQueryModel questionQueryModel){
        logger.info("请求开始deleteQueestionByid，逻辑删除",questionQueryModel.toString());
        SysResult sysResult = new SysResult();
        try{
            QuestionModel questionModel = new QuestionModel();
            questionModel.setQuesId(questionQueryModel.getQuesId());
            questionModel.setStatus(0);
            int a =  questionSercice.deleteQueestionByid(questionModel);
           sysResult.setCode(0);
        }catch (Exception e){
            logger.error("deleteQueestionByid信息异常{}");
        }
        return new SysResult(0,"逻辑删除成功");
    }
//    /**
//     * @Description:导出excel方法
//     * @author jibingfeng
//     * @date 2018/08/07
//     * @param request
//     * @return java.lang.Object
//     */
//    @RequestMapping(value = "/export_excel")
//    public void exportExcel(HttpServletRequest request,HttpServletResponse response){
//        ResponseBean rb = ResponseFunction.getResponseBeanNew("");
////        QuestionModel questionModel = getQueryModel(request);
//        QuestionQueryModel questionQueryModel = getQueryModel(request);
//        try{
//            List<QuestionModel> list = questionSercice.getQuestionMsg(questionQueryModel);
//            List<Map<String,Object>> maps = new ArrayList<>();
//            for (QuestionModel questionModel : list){
//                Map<String,Object> map = new LinkedHashMap<>();
//                map.put("试题ID", questionModel.getQuesId());
//                map.put("题目",questionModel.getQuestion());
//                map.put("答案1",questionModel.getAnswer());
//                map.put("答案2",questionModel.getAnswer1());
//                map.put("答案3",questionModel.getAnswer2());
//                map.put("答案4",questionModel.getAnswer3());
//                map.put("题型",questionModel.getQuesType());
//                map.put("科目",questionModel.getSubject());
//                map.put("题目解析",questionModel.getKeyPoint());
//                maps.add(map);
//            }
//            //创建EXCEL列表，写回客户端
//
//        }
//    }
    @CrossOrigin
    @RequestMapping("mangement")
    public Object jumpToView1(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        modelAndView.setViewName("admin/questionMangement");
        return modelAndView;
    }
}
