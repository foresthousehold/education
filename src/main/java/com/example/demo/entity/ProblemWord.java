package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * 大問説明クラス
 */
@Entity
@Table(name="problem_word")
public class ProblemWord extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 大問 */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Problem.class, optional = false)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    /** 用語(日本語) */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Word.class, optional = false)
    @JoinColumn(name = "word_id", nullable = false)
    private Word word;

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
