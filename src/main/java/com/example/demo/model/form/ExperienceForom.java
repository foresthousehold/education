package com.example.demo.model.form;

/**
 * 経験値フォーム
 */
public class ExperienceForom {

    // クエストID
    private Long questId; 

    // レベル
    private Long level;

    public Long getQuestId() {
        return questId;
    }

    public void setQuestId(Long questId) {
        this.questId = questId;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }    
}
