package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * 大問
 */
@Entity
@Table(name = "problem")
public class Problem extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 大問名 */
    @Column(name = "name", nullable = false)
    private String name;

    /** クエスト */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Quest.class, optional = false)
    @JoinColumn(name = "quest_id", nullable = false)
    private Quest quest;

    /** 問題一覧 */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
        targetEntity=Question.class, mappedBy = "problem")
    private List<Question> questions;
    
    /** 問題画像一覧 */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
    targetEntity=Image.class, mappedBy = "problem")
    private List<Image> images;

    /** 動画*/
    @OneToOne(mappedBy = "problem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Video video;

    /** 並び順 */
    @Column(name = "sort_order", nullable = false)
    private Long sortOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    

}
