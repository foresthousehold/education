package com.example.demo.model.form;

import java.util.List;

/**
 * クイズフォーム
 */
public class QuizForm {

    /** コースID */
    private Long courseId;

    /** 大問一覧 */
    private List<ProblemForm> problemForms;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<ProblemForm> getProblemForms() {
        return problemForms;
    }

    public void setProblemForms(List<ProblemForm> problemForms) {
        this.problemForms = problemForms;
    }

}
