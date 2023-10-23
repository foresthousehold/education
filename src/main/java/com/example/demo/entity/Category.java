package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 分類名 */
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
