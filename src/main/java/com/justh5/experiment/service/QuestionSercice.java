package com.justh5.experiment.service;

import com.justh5.experiment.model.questionBank.QuestionModel;
import com.justh5.experiment.model.questionBank.QuestionQueryModel;

import java.util.List;

public interface QuestionSercice {
    /**
     * 查询题库
     * @param questionQueryModel
     * @return
     */
    List<QuestionModel> getQuestionMsg(QuestionQueryModel questionQueryModel);

    /**
     * 新增题目
     * @param questionModel
     * @return
     */
    int addQuestion(QuestionModel questionModel);

    /**
     * 更新/修改题目
     * @param questionModel
     * @return
     */
    int updateQuestion(QuestionModel questionModel);

    /**
     * 逻辑删除题目
     * @param questionModel
     * @return
     */
    int deleteQueestionByid(QuestionModel questionModel);
}
