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
 * 料理
 */
@Entity
@Table(name = "dish")
public class Dish extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 料理名 */
    @Column(name = "name")
    private String name;

    /** クエスト */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
            CascadeType.REMOVE }, fetch = FetchType.LAZY, targetEntity = Quest.class, mappedBy = "dish")
    private List<Quest> quests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }
 
}
