package com.example.demo.model.form;

/**
 * 解答選択フォーム
 */
public class AnswerChoiceForm {

    /** コンテンツ */
    private String content;

    /** 正答フラグ */
    private boolean correctFlg;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrectFlg() {
        return correctFlg;
    }

    public void setCorrectFlg(boolean correctFlg) {
        this.correctFlg = correctFlg;
    }

}
