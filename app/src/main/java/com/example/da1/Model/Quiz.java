package com.example.da1.Model;

public class Quiz {
    private String subjectName;
    private Integer quizTime;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(Integer quizTime) {
        this.quizTime = quizTime;
    }

    public Quiz() {
    }

    public Quiz(String subjectName, Integer quizTime) {
        this.subjectName = subjectName;
        this.quizTime = quizTime;
    }
}
