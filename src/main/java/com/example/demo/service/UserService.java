package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.form.UserForm;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired 
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * ユーザを作成します。
     * @param userForm
     * @return
     */
    public User createUser(UserForm userForm) {
        
        // ユーザマスタ
        final User user = userRepository.save(convertFormToEntityUser(new User(), userForm));

        return user;
    }

    /**
     * ユーザフォームの情報からユーザエンティティを作成します。
     * @param entity
     * @param userForm
     * @return
     */
    public User convertFormToEntityUser(User entity, UserForm userForm) {
        entity.setUsername(userForm.getUserName());
        entity.setPassword(passwordEncoder.encode(userForm.getPassword()));
        entity.setDeleteFlg(false);

        return entity;
    }

}
