package com.example.demo.model.form;

/**
 * 解答選択フォーム
 */
public class AnswerChoiceForm {

    /** 選択肢を識別するID */
    private Long id;

    /** コンテンツ */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
