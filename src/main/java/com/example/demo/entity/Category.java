package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 分類名 */
    @Column(name = "name")
    private String name;

    /** クエストカテゴリ- */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, targetEntity = QuestCategory.class, mappedBy = "category")
    @OrderBy("id asc")
    private List<QuestCategory> questCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
