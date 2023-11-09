package com.example.demo.controller;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AccountDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired 
    UserRepository userRepository;

    @Autowired
    UserService userService;

    /**
     * コース選択画面を表示します。
     * @param model モデル
     * @return コース選択画面
     * @throws IOException
     */
    @GetMapping("/select")
    public String select(
        @AuthenticationPrincipal AccountDetails accountDetails,
        Model model) throws IOException {

        final User user =  userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
        
        model.addAttribute("profileForm", userService.createProfileForm(user));
        model.addAttribute("courses", courseRepository.findAll());

        return "course/select";
    }
}
