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

    /** 選択ID */
    private Long choicedAnswerId;

    /** アドバイス */
    private String advice;

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

    public Long getChoicedAnswerId() {
        return choicedAnswerId;
    }

    public void setChoicedAnswerId(Long choicedAnswerId) {
        this.choicedAnswerId = choicedAnswerId;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }


}
