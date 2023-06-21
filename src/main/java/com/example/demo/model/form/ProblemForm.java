package com.example.demo.model.form;

import java.util.List;

/**
 * 大問フォーム
 */
public class ProblemForm {

    // 大問ID
    private Long problemNo;

    // 問題画像ファイルパス一覧
    private List<String> imgPaths;

    // 問題フォーム一覧
    private List<QuestionForm> questionForms;

    // 動画パス
    private String videoPath;

    // 不正解数
    private int misstakeCount;

    public Long getProblemNo() {
        return problemNo;
    }

    public void setProblemNo(Long problemNo) {
        this.problemNo = problemNo;
    }

    public List<String> getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(List<String> imgPaths) {
        this.imgPaths = imgPaths;
    }

    public List<QuestionForm> getQuestionForms() {
        return questionForms;
    }

    public void setQuestionForms(List<QuestionForm> questionForms) {
        this.questionForms = questionForms;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public int getMisstakeCount() {
        return misstakeCount;
    }

    public void setMisstakeCount(int misstakeCount) {
        this.misstakeCount = misstakeCount;
    }

}