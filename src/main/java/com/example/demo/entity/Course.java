package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * コース
 */
@Entity
@Table(name="course")
public class Course extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** コース名 */
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /** クエスト一覧 */
    @OneToMany(targetEntity=Quest.class, fetch=FetchType.LAZY, mappedBy = "course")
    private List<Quest> quests;

    /** 画像 */
    @Column(name = "image_path", nullable = false)
    private String imagePath;

    /** 並び順 */
    @Column(name = "sort_order", nullable = false)
    private Long sortOrder;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }
}
