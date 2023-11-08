package com.example.demo.model.form;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class UserForm {

    /** ユーザ名 */
    @NotBlank(message = "ユーザ名を入力してください")
    private String userName;

    /** パスワード */
    @NotBlank(message = "パスワードを入力してください")
    private String password;

    /** アカウントアイコン */
    private MultipartFile accountIcon;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getAccountIcon() {
        return accountIcon;
    }

    public void setAccountIcon(MultipartFile accountIcon) {
        this.accountIcon = accountIcon;
    }
}
