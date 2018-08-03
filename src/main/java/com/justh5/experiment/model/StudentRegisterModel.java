package com.justh5.experiment.model;

public class StudentRegisterModel {
    /**
     * ID
     */
    private Integer stuId;
    /**
     * 姓名
     */
    private String stuName;
    /**
     * 密码
     */
    private String stuPwd;
    /**
     * 年级
     */
    private String grade;
    /**
     * 性别
     */
    private String stuSex;
    /**
     * 班级
     */
    private String myClass;
    /**
     * 专业
     */
    private String academy;
    /**
     * 学院
     */
    private String professional;

    /**
     * 学号
     * @return
     */
    private String stuNum;

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getMyClass() {
        return myClass;
    }

    public void setMyClass(String myClass) {
        this.myClass = myClass;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public StudentRegisterModel() {
    }
    public StudentRegisterModel(Integer stuId, String stuName, String stuPwd, String grade, String stuSex, String myClass, String academy, String professional, String stuNum) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuPwd = stuPwd;
        this.grade = grade;
        this.stuSex = stuSex;
        this.myClass = myClass;
        this.academy = academy;
        this.professional = professional;
        this.stuNum = stuNum;
    }
}
