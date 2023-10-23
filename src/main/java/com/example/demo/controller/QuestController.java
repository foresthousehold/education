package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.AccountDetails;
import com.example.demo.entity.Problem;
import com.example.demo.entity.Process;
import com.example.demo.entity.Question;
import com.example.demo.entity.User;
import com.example.demo.entity.Word;
import com.example.demo.model.form.ProblemForm;
import com.example.demo.model.form.QuestionForm;
import com.example.demo.model.form.SearchForm;
import com.example.demo.repository.ProblemRepository;
import com.example.demo.repository.ProcessRepository;
import com.example.demo.repository.QuestRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WordRepository;
import com.example.demo.service.QuestService;

@Controller
@RequestMapping("/quest")
public class QuestController {

    @Autowired
    ProblemRepository problemRepository;

    @Autowired 
    ProcessRepository processRepository;

    @Autowired
    QuestService questService;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WordRepository wordRepository;

    /**
     * クエスト選択画面を表示します。
     * @param model モデル
     */
    @GetMapping("/select/{courseId}")
    public String selectQuest(
        @PathVariable(name = "courseId") Long courseId, 
        @AuthenticationPrincipal AccountDetails accountDetails,
        Model model) {

        final User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
        final SearchForm searchForm = questService.createSearchForm();

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("quests", questRepository.findAll());
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("level", user.getLevel());

        return "quest/select";
    }

    /**
     * クエスト選択検索結果画面を表示します
     * @param questId
     * @param accountDetails
     * @param model
     * @return
     */
    @GetMapping("/search-result")
    public String search(
        @AuthenticationPrincipal AccountDetails accountDetails,
        Model model) {

        final User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
        final SearchForm searchForm = questService.createSearchForm();

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("quests", questRepository.findAll());
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("level", user.getLevel());
        
        return "/quest/select";
    }

    /**
     * プロセス画面を表示します。
     * @return プロセス画面
     */
    @GetMapping("process/{questId}")
    public String process(
        @PathVariable(name = "questId") Long questId, 
        @AuthenticationPrincipal AccountDetails accountDetails,
        Model model) {

            final User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);

            // クエストIDからクエストに紐づく全てのプロセスを取得
            final List<Process> processes = processRepository.findByQuestId(questId);
            Long courseId = processes.get(0).getQuest().getCourse().getId();

            model.addAttribute("courseId", courseId);
            model.addAttribute("processes", processes);
            model.addAttribute("userName", user.getUsername());
            model.addAttribute("level", user.getLevel());

            return "process/select";
    }

    /**
     * 問題画面を表示します。
     * @param model モデル
     */
    @GetMapping("/{processId}")
    public String getQuest(
        @PathVariable(name = "processId") Long processId,
        Model model, 
        @AuthenticationPrincipal AccountDetails accountDetails) {
        // クエスト選択された時、クエストIDに紐づく大問の一つ目を表示
        // formを作ってsetして返す
        // ①getされた時は必ず一番初めの大問を表示する
        // 大問フォーム一覧を作成
        final User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
        // final Long problemId = problemRepository.findByProcessId(processId);
        ProblemForm problemForm = questService.createFirstProblemForm(processId);
        final Long experience = processRepository.findById(processId).map(q -> q.getExperience()).orElseThrow(EntityNotFoundException::new);

        // 大問IDから全ての用語を取得します。
        final List<Word> words = wordRepository.findByProblemId(problemForm.getProblemNo());
        
        model.addAttribute("words", words);
        model.addAttribute("processId", processId);
        model.addAttribute("problemForm", problemForm);
        model.addAttribute("displayExperienceFlg", true);
        model.addAttribute("totalExperience", user.getTotalExperience());
        model.addAttribute("experience", experience);
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("level", user.getLevel());
        model.addAttribute("unSelectedFlg", false);

        return "quest/quest";
    }

    /**
     * 正誤判定をします
     * @param model モデル
     */
    @PostMapping("/{processId}")
    public String postQuest(
        @PathVariable(name = "processId") Long processId,
        @RequestParam("problemNo") Long problemNo,
        ProblemForm problemForm,
        RedirectAttributes redirectAttributes,
        Model model,
        @AuthenticationPrincipal AccountDetails accountDetails) {

        // アカウント詳細IDからユーザを取得
        final User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);

        Problem problem = problemRepository.findByProcessIdAndProblemNo(processId, problemNo).orElseThrow();

        final Long experience = processRepository.findById(processId).map(q -> q.getExperience()).orElseThrow(EntityNotFoundException::new);

        // ユーザ情報からユーザの保持経験値を取得する
        final Long totalExperience = user.getTotalExperience();

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

        // 大問IDから全ての用語を取得します。
        final List<Word> words = wordRepository.findByProblemId(problemForm.getProblemNo());
        
        // 一つでも間違いがあった場合、formにアドバイスをセット
        if (!isAllCorrect) {
            ProblemForm adviceProblemForm = questService.createProblemForm(processId, problemForm);

            // 再度同じ大問を表示する
            model.addAttribute("words", words);
            model.addAttribute("problemForm", adviceProblemForm);
            model.addAttribute("displayExperienceFlg", true);
            model.addAttribute("totalExperience", totalExperience);
            model.addAttribute("experience", experience);
            model.addAttribute("userName", user.getUsername());
            model.addAttribute("level", user.getLevel());
            model.addAttribute("unSelectedFlg", false);
            return "quest/quest";
        }

        // 表示する大問があるかどうか判定するための変数(次の問題)
        Optional<Problem> nextProblem = problemRepository.findByProcessIdAndProblemNo(processId, problem.getProblemNo() + 1);

        if (nextProblem.isEmpty()) {
            ProblemForm adviceProblemForm = questService.createProblemForm(processId, problemForm);

            // ユーザのレベルを上げます(ユーザ情報、クエストが持つ経験値)
            questService.updateUserLevel(user, experience);

           // processIDからプロセスを取得し、フラグをtrueにする
            questService.updateAccessFlg(processId+1);

            // 再度同じ大問を表示する
            model.addAttribute("words", words);
            model.addAttribute("problemForm", adviceProblemForm);
            model.addAttribute("displayExperienceFlg", false);
            model.addAttribute("totalExperience", totalExperience);
            model.addAttribute("experience", experience);
            model.addAttribute("userName", user.getUsername());
            model.addAttribute("level", user.getLevel());
            model.addAttribute("unSelectedFlg", true);

            return "quest/quest";
        }

        // 全て正答だった場合、次の大問用のformをセット
        // 正誤対象の大問ID+1で一覧から取得しformにセット
        model.addAttribute("words", words);
        model.addAttribute("processId", processId);
        model.addAttribute("problemForm", questService.createProblemForm(processId, problem.getProblemNo() + 1));
        model.addAttribute("displayExperienceFlg", true);
        model.addAttribute("totalExperience", totalExperience);
        model.addAttribute("experience", experience);
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("level", user.getLevel());
        model.addAttribute("unSelectedFlg", false);

        return "quest/quest";
    }

}