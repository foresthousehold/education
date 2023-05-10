package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

@Entity
@Table(name = "image")
public class Image extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** ファイルパス */
    @Column(name = "file_path")
    private String filePath;

    /** 問題 */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Problem.class, optional = false)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    /** 並び順 */
    @Column(name = "sort_order")
    private Long sortOrder;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

}
