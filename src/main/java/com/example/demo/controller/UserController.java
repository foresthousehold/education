package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repository.CourseRepository;

@Controller
public class UserController {
    @Autowired
    CourseRepository courseRepository;

    /**
     * ログイン画面を表示します
     * @return ログイン画面
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * ログアウトします
     */
    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
    
}
