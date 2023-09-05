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

    /** プロセス */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Process.class, optional = false)
    @JoinColumn(name = "process_id", nullable = false)
    private Process process;

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
    @Column(name = "problem_no", nullable = false)
    private Long problemNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
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

    public Long getProblemNo() {
        return problemNo;
    }

    public void setProblemNo(Long problemNo) {
        this.problemNo = problemNo;
    }
}
