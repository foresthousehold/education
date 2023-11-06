package com.example.demo.model.form;

import com.example.demo.entity.Quest;

/**
 * クエストフォーム
 */
public class QuestForm {

    /** クエスト */
    private Quest quest;

    /** 継承フラグ */
    private boolean extendFlg;

    /** インターフェースフラグ */
    private boolean interfaceFlg;

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public boolean isExtendFlg() {
        return extendFlg;
    }

    public void setExtendFlg(boolean extendFlg) {
        this.extendFlg = extendFlg;
    }

    public boolean isInterfaceFlg() {
        return interfaceFlg;
    }

    public void setInterfaceFlg(boolean interfaceFlg) {
        this.interfaceFlg = interfaceFlg;
    }
}
