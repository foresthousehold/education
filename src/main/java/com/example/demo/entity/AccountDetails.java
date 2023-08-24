package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountDetails implements UserDetails{

    // アカウントID
    private Long id;

    // 利用者名
    private String username;

    // パスワード
    private String password;

    // 累積経験値
    private Long totalExperience;

    // レベル
    private Long level;

    /**
     * 利用者コンストラクタ
     * @param id アカウントID
     * @param username 利用者名
     * @param password パスワード
     * @param level レベル
     */
    public AccountDetails(Long id, String username, String password, Long totalExperience, Long level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.totalExperience = totalExperience;
        this.level = level;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * アカウントのIDを取得します。
     * @return アカウントのID
     */
    public Long getId() {
        return this.id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 累積経験値を取得します.
     * @return 累積経験値
     */
    public Long getTotalExperience() {
        return this.totalExperience;
    }

    /**
     * 累積経験値をセットします.
     * @param 累積経験値
     */
    public void setTotalExperience(Long totalExperience) {
        this.totalExperience = totalExperience;
    }

    /**
     * レベルを取得します。
     * @return
     */
    public Long getLevel() {
        return level;
    }

    /**
     * レベルをセットします。
     * @param level
     */
    public void setLevel(Long level) {
        this.level = level;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
