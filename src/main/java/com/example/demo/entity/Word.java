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

    /** 分類名 */
    @Column(name = "classification_name")
    private String classificationName;

    /** 解説 */
    @Column(name = "comment")
    private String comment;

    /** 大問用語 */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
    fetch = FetchType.LAZY, targetEntity = ProblemWord.class, mappedBy = "word")
    private List<ProblemWord> problemWords;

      /** 参考サイト */

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ProblemWord> getProblemWords() {
        return problemWords;
    }

    public void setProblemWords(List<ProblemWord> problemWords) {
        this.problemWords = problemWords;
    }

}
