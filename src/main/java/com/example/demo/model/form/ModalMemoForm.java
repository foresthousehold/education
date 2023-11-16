package com.example.demo.model.form;

public class ModalMemoForm {
    /** メモID */
    private Long id;

    /** タイトル */
    private String title;

    /** コンテンツ */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
