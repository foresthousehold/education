package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 *  利用者
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** ユーザネーム */
    @Column(name = "username", nullable = false)
    private String username;

    /** パスワード */
    @Column(name = "password", nullable = false)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
