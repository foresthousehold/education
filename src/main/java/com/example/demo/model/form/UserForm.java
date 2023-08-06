package com.example.demo.model.form;

import javax.validation.constraints.NotBlank;

public class UserForm {

    @NotBlank(message = "ユーザ名を入力してください")
    private String userName;

    @NotBlank(message = "パスワードを入力してください")
    private String password;

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
    
}
