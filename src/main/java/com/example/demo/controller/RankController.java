package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.AccountDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class RankController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired 
    UserRepository userRepository;

    /**
     * ランキング画面を表示します。
     * @param model モデル
     * @return コース選択画面
     */
    @GetMapping("/rank")
    public String rank(
        @AuthenticationPrincipal AccountDetails accountDetails,
        Model model) {

        User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
        List<User> users = userRepository.findAllSortByLevel();

        model.addAttribute("users", users);
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("level", user.getLevel());

        return "rank/select";
    }
}
