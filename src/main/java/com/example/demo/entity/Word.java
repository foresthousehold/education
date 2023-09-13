package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * 用語クラス
 */
@Entity
@Table(name="word")
public class Word extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    /** 分類名(日本語) */
    @Column(name = "japanese_classification")
    private String japaneseClassification;

    /** 分類名(英語) */
    @Column(name = "english_classification")
    private String englishClassification;

    /** 解説(日本語) */
    @Column(name = "japanese_comment")
    private String japaneseComment;

    /** 解説(英語) */
    @Column(name = "english_comment")
    private String englishComment;

    /** 大問用語 */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
    fetch = FetchType.LAZY, targetEntity = ProblemWord.class, mappedBy = "word")
    private List<ProblemWord> problemWords;

    public String getJapaneseClassification() {
        return japaneseClassification;
    }

    public void setJapaneseClassification(String japaneseClassification) {
        this.japaneseClassification = japaneseClassification;
    }

    public String getEnglishClassification() {
        return englishClassification;
    }

    public void setEnglishClassification(String englishClassification) {
        this.englishClassification = englishClassification;
    }

    public String getJapaneseComment() {
        return japaneseComment;
    }

    public void setJapaneseComment(String japaneseComment) {
        this.japaneseComment = japaneseComment;
    }

    public String getEnglishComment() {
        return englishComment;
    }

    public void setEnglishComment(String englishComment) {
        this.englishComment = englishComment;
    }

    public List<ProblemWord> getProblemWords() {
        return problemWords;
    }

    public void setProblemWords(List<ProblemWord> problemWords) {
        this.problemWords = problemWords;
    }
}
