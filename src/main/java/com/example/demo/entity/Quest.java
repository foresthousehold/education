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
 * クエスト
 */
@Entity
@Table(name = "quest")
public class Quest extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** クエスト名 */
    @Column(name = "name", nullable = false)
    private String name;

    /** コース */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    /** プロセス */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
    fetch = FetchType.LAZY, targetEntity = Process.class, mappedBy = "quest")
    private List<Process> processes;

    /** 画像 */
    @Column(name = "image_path", nullable = false)
    private String imagePath;

    /** 並び順 */
    @Column(name = "sort_order", nullable = false)
    private Long sortOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
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
