package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/** クエストカテゴリー */
@Entity
@Table(name = "quest_category")
public class QuestCategory extends BaseEntity {

    /** クエスト */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Quest.class, optional = false)
    @JoinColumn(name = "quest_id")
    private Quest quest;

    /** カテゴリ */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
