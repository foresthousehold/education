package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.AccountDetails;
import com.example.demo.entity.User;
import com.example.demo.model.form.RankForm;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class RankController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    /**
     * ランキング画面を表示します。
     * 
     * @param model モデル
     * @return コース選択画面
     * @throws IOException
     * @throws Exception
     */
    @GetMapping("/rank")
    public String rank(
            @AuthenticationPrincipal AccountDetails accountDetails,
            Model model) {
        try {
            // ここにファイルや入出力関連の処理があると仮定
            // 例: Files.readAllLinesや、InputStream/OutputStreamの利用など

            User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
            List<User> users = userRepository.findAllSortByLevel();
            // ユーザごとにランクフォームを作成する
            List<RankForm> rankForms = users.stream().map(u -> {
                try {
                    return userService.createRankForm(u);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new EntityNotFoundException();
                }
            })
                    .collect(Collectors.toList());

            model.addAttribute("rankForms", rankForms);
            model.addAttribute("profileForm", userService.createProfileForm(user));

            return "rank/select";
        } catch (IOException e) {
            // IOExceptionが発生した場合の処理を記述
            // 例外をキャッチして適切な処理を行うか、ログに出力するなど
            return "error"; // エラーが発生した場合に遷移するページを指定
        }
    }

}
