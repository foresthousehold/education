package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    /** プロフィール画像の保存先フォルダ */
    @Value("${image.folder}")
    private String imgFolder;

    /** プロフィール画像の保存拡張子 */
    @Value("${image.extract}")
    private String imgExtract;

    /**
     * ユーザを作成します。
     * 
     * @param userForm
     * @return
     */
    @Transactional
    public User createUser(UserForm userForm) throws IOException {

        if(!userForm.getAccountIcon().isEmpty()) {
            // 保存する画像ファイルパスの設定
            // ファイルパス: ユーザネーム+.jpg
            var saveFileName = userForm.getUserName() + imgExtract;
            Path imgFilePath = Path.of(imgFolder, saveFileName);

            // 画像ファイルの保存(フォルダ)
            Files.copy(userForm.getAccountIcon().getInputStream(), imgFilePath);
        }

        // ユーザマスタ
        final User user = userRepository.save(convertFormToEntityUser(new User(), userForm));

        return user;
    }

    /**
     * ユーザフォームの情報からユーザエンティティを作成します。
     * 
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
