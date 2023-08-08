package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Problem;
import com.example.demo.entity.Question;
import com.example.demo.model.form.ProblemForm;
import com.example.demo.model.form.QuestionForm;
import com.example.demo.repository.ProblemRepository;
import com.example.demo.repository.QuestRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestService;

@Controller
@RequestMapping("/quest")
public class QuestController {

    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    QuestService questService;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestionRepository questionRepository;

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

    /**
     * 問題画面を表示します。
     * @param model モデル
     */
    @GetMapping("/{questId}")
    public String getQuest(
        @PathVariable(name = "questId") Long questId,
        Model model) {
        // クエスト選択された時、クエストIDに紐づく大問の一つ目を表示
        // formを作ってsetして返す
        // ①getされた時は必ず一番初めの大問を表示する
        // 大問フォーム一覧を作成
        ProblemForm problemForm = questService.createFirstProblemForm(questId);

        model.addAttribute("questId", questId);
        model.addAttribute("problemForm", problemForm);
        model.addAttribute("displayExperienceFlg", true);

        return "quest/quest";
    }

    /**
     * 正誤判定をします
     * @param model モデル
     */
    @PostMapping("/{questId}")
    public String postQuest(
        @PathVariable(name = "questId") Long questId,
        @RequestParam("problemNo") Long problemNo,
        ProblemForm problemForm,
        RedirectAttributes redirectAttributes,
        Model model) {
        Problem problem = problemRepository.findByQuestIdAndProblemNo(questId, problemNo).orElseThrow();

        // 大問が取得できなかった場合、全ての大問が時終わったのでクエスト選択画面に遷移
        if (problem.equals(null)) {
            return "quest/select";
        }

        // 大問から紐づく小問一覧を取得
        List<Question> questions = questionRepository.findByProblemId(problem.getId());
        
        // 取得した小問一覧から小問ごとに小問IDに紐づく正答の選択肢を取得
        Map<Long, Long> answerChoiceIdMap = questService.createAnswerChoiceIdMap(questions);

        List<QuestionForm> questionForms = problemForm.getQuestionForms();

        // 正誤判定
        boolean isAllCorrect = questionForms.stream().allMatch(q -> answerChoiceIdMap.get(q.getQuestionId()).equals(q.getChoicedAnswerId()));
        
        // 一つでも間違いがあった場合、formにアドバイスをセット
        if (!isAllCorrect) {
            ProblemForm adviceProblemForm = questService.createProblemForm(questId, problemForm);

            // 再度同じ大問を表示する
            model.addAttribute("problemForm", adviceProblemForm);
            return "quest/quest";
        }

        // 表示する大問があるかどうか判定するための変数(次の問題)
        Optional<Problem> nextProblem = problemRepository.findByQuestIdAndProblemNo(questId, problem.getProblemNo() + 1);

        // 表示する大問があるかどうか判定するための変数(次の次の問題)
        // 経験値画面表示フラグ
        boolean displayExperienceFlg = problemRepository.findByQuestIdAndProblemNo(questId, problem.getProblemNo() + 2).isPresent();

        // 全て正答だった場合、次の大問用のformをセット
        // 正誤対象の大問ID+1で一覧から取得しformにセット
        model.addAttribute("questId", questId);
        model.addAttribute("problemForm", questService.createProblemForm(questId, problem.getProblemNo() + 1));
        model.addAttribute("displayExperienceFlg", displayExperienceFlg);

        return "quest/quest";
    }

}