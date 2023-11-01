package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * 解答選択肢
 */
@Entity
@Table(name = "answer_choice")
public class AnswerChoice extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 小問 */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Question.class, optional = false)
    @JoinColumn(name = "question_id")
    private Question question;

    /** 正答フラグ */
    @Column(name = "correct_flg")
    private boolean correctFlg;

    /** コンテンツ */
    @Column(name = "content")
    private String content;

    /** アドバイス */
    @Column(name = "advice", nullable = false)
    private String advice;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrectFlg() {
        return correctFlg;
    }

    public void setCorrectFlg(boolean correctFlg) {
        this.correctFlg = correctFlg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

}
