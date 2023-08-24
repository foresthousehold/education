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

    /** 累積経験値 */
    @Column(name = "total_experience", nullable = false)
    private Long totalExperience;

    /** レベル */
    @Column(name = "level", nullable = false)
    private Long level;

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

    public Long getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Long totalExperience) {
        this.totalExperience = totalExperience;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    
}
