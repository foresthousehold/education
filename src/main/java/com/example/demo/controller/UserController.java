package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.form.UserForm;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * ログイン画面を表示します
     * 
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

    /**
     * ユーザ登録画面を表示します。
     * 
     * @return ユーザ登録画面
     */
    @GetMapping("/create/user")
    public String create(@ModelAttribute UserForm userForm) {
        return "/user/create";
    }

    /**
     * ユーザ登録をします。
     * 
     * @return ログイン画面
     * @throws IOException
     */
    @PostMapping("/create/user")
    public String create(@Validated UserForm userForm, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return create(userForm);
        }

        userService.createUser(userForm);

        return "login";
    }

}
