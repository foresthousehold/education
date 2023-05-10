package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.QuestRepository;

@Controller
@RequestMapping("/quest")
public class QuestController {
    @Autowired
    QuestRepository questRepository;

    /**
     * クエスト選択画面を表示します。
     * @param model モデル
     */
    @GetMapping("/select/{courseId}")
    public String selectQuest(
        @PathVariable(name = "courseId") Long courseId, Model model) {
            // コースIDに紐づくクエスト一覧を取得する
            model.addAttribute("quests", questRepository.findAll());

            return "quest/select";
    }
}
