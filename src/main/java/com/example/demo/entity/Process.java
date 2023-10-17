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
 * プロセス
 */
@Entity
@Table(name = "process")
public class Process extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    /** プロセス名 */
    @Column(name = "process_name", nullable = false)
    private String processName;

    /** クエスト */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Quest.class, optional = false)
    @JoinColumn(name = "quest_id", nullable = false)
    private Quest quest;

    /** 大問 */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
    fetch = FetchType.LAZY, targetEntity = Problem.class, mappedBy = "process")
    private List<Problem> problems;

    /** 経験値 */
    @Column(name = "experience", nullable = false)
    private Long experience;

    /** 画像 */
    @Column(name = "image_path", nullable = false)
    private String imagePath;

    /** アクセスフラグ */
    @Column(name = "access_flg", nullable=false)
    private Boolean accessFlg;

    /** 並び順　*/
    @Column(name = "sort_order", nullable = false)
    private Long sortOrder;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean isAccessFlg() {
        return accessFlg;
    }

    public void setAccessFlg(Boolean accessFlg) {
        this.accessFlg = accessFlg;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    } 
}
