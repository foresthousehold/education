package com.example.demo.model.form;

public class RankForm {

    /** ユーザ名 */
    private String userName;

    /** ユーザレベル */
    private Long level;

    /** 合計経験値 */
    private Long totalExperience;

    /** ユーザアイコン */
    private String profileIcon;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Long totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(String profileIcon) {
        this.profileIcon = profileIcon;
    }
}
