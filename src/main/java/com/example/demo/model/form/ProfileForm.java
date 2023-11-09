package com.example.demo.model.form;

/**
 * プロフィールフォーム
 */
public class ProfileForm {

    /** ユーザ名 */
    private String userName;

    /** レベル */
    private Long level;

    /** プロフィールアイコン */
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

    public String getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(String profileIcon) {
        this.profileIcon = profileIcon;
    }
}
