package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.form.ProfileForm;
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

    /** プロフィール画像のデフォルト画像の保管先フォルダ */
    @Value("${image.default}")
    private String imgDefault;

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

    /**
     * プロフィールフォームを作成します
     * @throws IOException
     */
    public ProfileForm createProfileForm(User user) throws IOException {

            // ProfileFormに必要なデータをセットする
            ProfileForm profileForm = new ProfileForm();
            profileForm.setUserName(user.getUsername());
            profileForm.setLevel(Optional.ofNullable(user.getLevel()).isEmpty() ? 1L : user.getLevel());
            profileForm.setProfileIcon("data:image/jpg;base64," + outPutImage(user.getUsername()));

            return profileForm;
    }

    /** 
     * プロフィールアイコンを出力します 
     * @throws IOException
     */
    public String outPutImage(String userName) throws IOException {
        // ファイルの検索
        Path path = searchImagePath(userName);

        // ファイルの読み込み
        byte[] byteImg = Files.readAllBytes(path);

        return Base64.getEncoder().encodeToString(byteImg);
    }

    /**
     * ユーザIDに紐づくプロフィール画像のパスを検索する。
     * 未登録の場合はデフォルトの画像パスを返す。
     */
    public Path searchImagePath(String userName) {
        String targetFileName = userName + imgExtract;

        // フルパスの作成
        Path targetPath = Path.of(imgFolder, targetFileName);

        return Files.exists(targetPath) ? targetPath : Path.of(imgFolder, imgDefault + imgExtract);
    }
}
