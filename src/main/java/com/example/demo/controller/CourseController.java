package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.CourseRepository;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    /**
     * コース選択画面を表示します。
     * @param model モデル
     * @return コース選択画面
     */
    @GetMapping("/select")
    public String select(Model model) {
        model.addAttribute("courses", courseRepository.findAll());

        return "course/select";
    }
}
