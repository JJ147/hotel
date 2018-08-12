package com.justh5.experiment.model.questionBank;

/**
 * 试题实体
 */
public class QuestionModel {
    /**
     * 试题id
     */
    private Integer quesId;
    /**
     * 试题
     */
    private String question;
    /**
     * 答案一
     */
    private String answer;
    /**
     * 答案2
     */
    private String answer1;
    /**
     * 答案3
     */
    private String answer2;
    /**
     * 答案4
     */
    private String answer3;
    /**
     * 题型
     */
    private String quesType;
    /**
     * 知识点/解析
     */
    private String keyPoint;
    /**
     * 科目
     */
    private String subject;

    /**
     * 试题状态：1为存在，2为删除。
     * @return
     */
    private int status;

    public Integer getQuesId() {
        return quesId;
    }

    public void setQuesId(Integer quesId) {
        this.quesId = quesId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getQuesType() {
        return quesType;
    }

    public void setQuesType(String quesType) {
        this.quesType = quesType;
    }

    public String getKeyPoint() {
        return keyPoint;
    }

    public void setKeyPoint(String keyPoint) {
        this.keyPoint = keyPoint;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public QuestionModel() {
    }
    public QuestionModel(Integer quesId, String question, String answer, String answer1, String answer2, String answer3, String quesType, String keyPoint, String subject, int status) {
        this.quesId = quesId;
        this.question = question;
        this.answer = answer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.quesType = quesType;
        this.keyPoint = keyPoint;
        this.subject = subject;
        this.status = status;
    }
}
