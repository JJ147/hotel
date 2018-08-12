package com.justh5.experiment.model.questionBank;

public class QuestionQueryModel {
        /**
         * 试题id
         */
        private Integer quesId;
        /**
         * 题型
         */
        private String quesType;
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

    public String getQuesType() {
        return quesType;
    }

    public void setQuesType(String quesType) {
        this.quesType = quesType;
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

    @Override
    public String toString() {
        return "QuestionQueryModel{" +
                "quesId=" + quesId +
                ", quesType='" + quesType + '\'' +
                ", subject='" + subject + '\'' +
                ", status=" + status +
                '}';
    }
}
