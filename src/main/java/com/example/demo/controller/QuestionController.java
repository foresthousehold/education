package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.form.ProblemForm;
import com.example.demo.model.form.QuizForm;
import com.example.demo.repository.AnswerChoiceRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ProblemRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired QuestionService questionService;

    @Autowired ImageRepository imageRepository;

    @Autowired ProblemRepository problemRepository;

    @Autowired QuestionRepository questionRepository;

    @Autowired AnswerChoiceRepository answerChoiceRepository;

    /**
     * 問題画面を表示します
     */
    @GetMapping("/{questId}")
    public String question(
        @PathVariable(name = "questId") Long questId, 
        QuizForm quizForm,
        Model model) {

        // 大問フォーム一覧を作成
        final List<ProblemForm> problemForms = questionService.createProblemForms(questId);
        quizForm.setProblemForms(problemForms);

        model.addAttribute("quizForm", quizForm);

        return "question/question";
    }

    /**
     * 正誤判定をします
     */
    @PostMapping("/juge")
    public void juge() {
        
    }
    
}
