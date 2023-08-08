package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * 経験値
 */
@Entity
@Table(name = "experience")
public class Experience extends BaseEntity{

    /** レベル */
    @Column(name = "level")
    private Long level;

    /** レベルアップに必要な累積経験値 */
    @Column(name = "needTotalExperience")
    private Long needTotalExperience;

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getNeedTotalExperience() {
        return needTotalExperience;
    }

    public void setNeedTotalExperience(Long needTotalExperience) {
        this.needTotalExperience = needTotalExperience;
    }
    
}
