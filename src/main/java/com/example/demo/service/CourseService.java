package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.repository.UserLoginRepository;

/**
 * コースサービス
 */
@Service
public class CourseService {

    @Autowired
    UserLoginRepository userLoginRepository;

    /**
     * ユーザログイン情報を更新します。
     */
    public void updateUserLogin(User user) {

        // ログインユーザとログイン日時からユーザログインを取得する
        Optional<UserLogin> existUserLogin = userLoginRepository.findByUserIdAndCurrentDate(user.getId(),
                LocalDate.now());

        // ログインユーザが存在した場合、新しくユーザログインを作成する
        if (existUserLogin.isEmpty()) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUser(user);
            userLogin.setLoginDate(LocalDate.now());
            userLogin.setDeleteFlg(false);
            userLoginRepository.save(userLogin);
        }
    }
}
