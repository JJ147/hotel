package com.justh5.experiment.service.impl;

import com.justh5.experiment.mapper.QuestionDao;
import com.justh5.experiment.model.questionBank.QuestionModel;
import com.justh5.experiment.model.questionBank.QuestionQueryModel;
import com.justh5.experiment.service.QuestionSercice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("/QuestionSercice")
public class QuestionServiceImpl implements QuestionSercice{
    @Resource
    QuestionDao questionDao;
    @Override
    public List<QuestionModel> getQuestionMsg(QuestionQueryModel questionQueryModel) {
        return questionDao.getQuestionMsg(questionQueryModel);
    }

    @Override
    public int addQuestion(QuestionModel questionModel) {
        return questionDao.addQuestion(questionModel);
    }

    @Override
    public int updateQuestion(QuestionModel questionModel) {
        return questionDao.updateQuestion(questionModel);
    }

    @Override
    public int deleteQueestionByid(QuestionModel questionModel) {
        return questionDao.deleteQueestionByid(questionModel);
    }
}
