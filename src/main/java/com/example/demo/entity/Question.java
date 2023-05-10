package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * 問題(穴埋め)
 */
@Entity
@Table(name = "question")
public class Question extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 解答選択肢 */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
    fetch = FetchType.LAZY, targetEntity = AnswerChoice.class, mappedBy = "question")
    private List<AnswerChoice> answerChoices;

    /** 大問 */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Problem.class, optional = false)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    /** アドバイス */
    @Column(name = "advice", nullable = false)
    private String advice;

    /** 並び順 */
    @Column(name = "sort_order", nullable = false)
    private Long sortOrder;

    public List<AnswerChoice> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(List<AnswerChoice> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }


}
