package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

@Entity
@Table(name = "memo")
public class Memo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** タイトル */
    @Column(name = "title")
    private String title;

    /** コンテンツ */
    @Column(name = "content")
    private String content;

    /** 作成日 */
    @Column(name = "created_date")
    private LocalDate createdDate;

    /** 編集日 */
    @Column(name = "edited_date")
    private LocalDate editedDate;

    /** ユーザ */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(LocalDate editedDate) {
        this.editedDate = editedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
