package com.example.demo.model.form;

import java.util.List;

/**
 * 問題フォーム
 */
public class QuestionForm {

    /** 問題ID */
    private Long questionId;

    /** 選択肢フォーム一覧 */
    private List<AnswerChoiceForm> answerChoiceForms;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public List<AnswerChoiceForm> getAnswerChoiceForms() {
        return answerChoiceForms;
    }

    public void setAnswerChoiceForms(List<AnswerChoiceForm> answerChoiceForms) {
        this.answerChoiceForms = answerChoiceForms;
    }

}
