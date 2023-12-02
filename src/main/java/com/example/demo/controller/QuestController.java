package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.example.demo.entity.Quest;
import com.example.demo.entity.Question;
import com.example.demo.entity.User;
import com.example.demo.entity.Word;
import com.example.demo.model.form.ProblemForm;
import com.example.demo.model.form.QuestForm;
import com.example.demo.model.form.QuestionForm;
import com.example.demo.model.form.SearchForm;
import com.example.demo.model.parameter.quest.SearchCriteria;
import com.example.demo.repository.ProblemRepository;
import com.example.demo.repository.ProcessRepository;
import com.example.demo.repository.QuestRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WordRepository;
import com.example.demo.service.QuestService;
import com.example.demo.service.UserService;

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
        UserService userService;

        @Autowired
        WordRepository wordRepository;

        /**
         * クエスト選択画面を表示します。
         * 
         * @param model モデル
         * @throws IOException
         */
        @GetMapping("/select/{courseId}")
        public String selectQuest(
                        @PathVariable(name = "courseId") Long courseId,
                        @AuthenticationPrincipal AccountDetails accountDetails,
                        Model model) throws Exception {

                final User user = userRepository.findById(accountDetails.getId())
                                .orElseThrow(EntityNotFoundException::new);
                final SearchForm searchForm = questService.createSearchForm();
                final List<Quest> quests = questRepository.findAll();
                final List<QuestForm> questForms = quests.stream().map(q -> questService.createQuestForm(q))
                                .collect(Collectors.toList());

                model.addAttribute("searchForm", searchForm);
                model.addAttribute("questForms", questForms);
                model.addAttribute("profileForm", userService.createProfileForm(user));
                model.addAttribute("quests", questRepository.findAll());
                return "quest/select";
        }

        /**
         * クエスト選択検索結果画面を表示します
         * 
         * @param accountDetails 利用者詳細
         * @param searchForm     検索フォーム
         * @param model          モデル
         * @return クエスト検索結果画面
         * @throws IOException
         */
        @GetMapping("/search-result")
        public String search(
                        @AuthenticationPrincipal AccountDetails accountDetails,
                        SearchForm searchForm,
                        Model model) throws Exception {

                final User user = userRepository.findById(accountDetails.getId())
                                .orElseThrow(EntityNotFoundException::new);
                final SearchCriteria searchCriteria = questService.createSearchCriteria(searchForm);
                final SearchForm searchForm2 = questService.createSearchForm();
                final List<Quest> quests = questRepository.search(searchCriteria);

                final List<QuestForm> questForms = quests.stream()
                                .map(q -> questService.createQuestForm(q)).collect(Collectors.toList());

                model.addAttribute("searchForm", searchForm2);
                model.addAttribute("questForms", questForms);
                model.addAttribute("quests", questRepository.search(searchCriteria));
                model.addAttribute("profileForm", userService.createProfileForm(user));

                return "/quest/select";
        }

        /**
         * プロセス画面を表示します。
         * 
         * @return プロセス画面
         * @throws IOException
         */
        @GetMapping("process/{questId}")
        public String process(
                        @PathVariable(name = "questId") Long questId,
                        @AuthenticationPrincipal AccountDetails accountDetails,
                        Model model) throws Exception {

                final User user = userRepository.findById(accountDetails.getId())
                                .orElseThrow(EntityNotFoundException::new);

                // クエストIDからクエストに紐づく全てのプロセスを取得
                final List<Process> processes = processRepository.findByQuestId(questId);
                Long courseId = processes.get(0).getQuest().getCourse().getId();

                model.addAttribute("courseId", courseId);
                model.addAttribute("processes", processes);
                model.addAttribute("profileForm", userService.createProfileForm(user));

                return "process/select";
        }

        /**
         * 問題画面を表示します。
         * 
         * @param model モデル
         * @throws IOException
         */
        @GetMapping("/{processId}")
        public String getQuest(
                        @PathVariable(name = "processId") Long processId,
                        Model model,
                        @AuthenticationPrincipal AccountDetails accountDetails) throws Exception {
                // クエスト選択された時、クエストIDに紐づく大問の一つ目を表示
                // formを作ってsetして返す
                // ①getされた時は必ず一番初めの大問を表示する
                // 大問フォーム一覧を作成
                final User user = userRepository.findById(accountDetails.getId())
                                .orElseThrow(EntityNotFoundException::new);
                // final Long problemId = problemRepository.findByProcessId(processId);
                ProblemForm problemForm = questService.createFirstProblemForm(processId);
                final Process process = processRepository.findById(processId).orElseThrow(EntityNotFoundException::new);
                final Long experience = processRepository.findById(processId).map(q -> q.getExperience())
                                .orElseThrow(EntityNotFoundException::new);

                // 大問IDから全ての用語を取得します。
                final List<Word> words = wordRepository.findByProblemId(problemForm.getProblemNo());

                model.addAttribute("words", words);
                model.addAttribute("processId", processId);
                model.addAttribute("questId", process.getQuest().getId());
                model.addAttribute("problemForm", problemForm);
                model.addAttribute("displayExperienceFlg", true);
                model.addAttribute("totalExperience", user.getTotalExperience());
                model.addAttribute("experience", experience);
                model.addAttribute("profileForm", userService.createProfileForm(user));
                model.addAttribute("unSelectedFlg", false);

                return "quest/quest";
        }

        /**
         * 正誤判定をします
         * 
         * @param model モデル
         * @throws IOException
         */
        @PostMapping("/{processId}")
        public String postQuest(
                        @PathVariable(name = "processId") Long processId,
                        @RequestParam("problemNo") Long problemNo,
                        @RequestParam("questId") Long questId,
                        ProblemForm problemForm,
                        RedirectAttributes redirectAttributes,
                        Model model,
                        @AuthenticationPrincipal AccountDetails accountDetails) throws Exception {

                // アカウント詳細IDからユーザを取得
                final User user = userRepository.findById(accountDetails.getId())
                                .orElseThrow(EntityNotFoundException::new);

                Problem problem = problemRepository.findByProcessIdAndProblemNo(processId, problemNo).orElseThrow();

                final Long experience = processRepository.findById(processId).map(q -> q.getExperience())
                                .orElseThrow(EntityNotFoundException::new);

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
                boolean isAllCorrect = questionForms.stream()
                                .allMatch(q -> answerChoiceIdMap.get(q.getQuestionId()).equals(q.getChoicedAnswerId()));

                // questionFormごとに回して、正答と一致しないものを抽出する。
                List<QuestionForm> filteredQuestionForms = questionForms.stream()
                                .filter(q -> !answerChoiceIdMap.get(q.getQuestionId()).equals(q.getChoicedAnswerId()))
                                .collect(Collectors.toList());

                // 大問IDから全ての用語を取得します。
                final List<Word> words = wordRepository.findByProblemId(problemForm.getProblemNo());

                // 一つでも間違いがあった場合、formにアドバイスをセット
                if (!isAllCorrect) {
                        ProblemForm adviceProblemForm = questService.createProblemForm(processId, problemForm,
                                        filteredQuestionForms);

                        // 再度同じ大問を表示する
                        model.addAttribute("words", words);
                        model.addAttribute("questId", questId);
                        model.addAttribute("problemForm", adviceProblemForm);
                        model.addAttribute("displayExperienceFlg", true);
                        model.addAttribute("totalExperience", totalExperience);
                        model.addAttribute("experience", experience);
                        model.addAttribute("profileForm", userService.createProfileForm(user));
                        model.addAttribute("unSelectedFlg", false);
                        return "quest/quest";
                }

                // 表示する大問があるかどうか判定するための変数(次の問題)
                Optional<Problem> nextProblem = problemRepository.findByProcessIdAndProblemNo(processId,
                                problem.getProblemNo() + 1);

                if (nextProblem.isEmpty()) {
                        ProblemForm adviceProblemForm = questService.createProblemForm(processId, problemForm,
                                        filteredQuestionForms);

                        // ユーザのレベルを上げます(ユーザ情報、クエストが持つ経験値)
                        questService.updateUserLevel(user, experience);

                        // processIDからプロセスを取得し、フラグをtrueにする
                        questService.updateAccessFlg(processId + 1);

                        // 再度同じ大問を表示する
                        model.addAttribute("words", words);
                        model.addAttribute("questId", questId);
                        model.addAttribute("problemForm", adviceProblemForm);
                        model.addAttribute("displayExperienceFlg", false);
                        model.addAttribute("totalExperience", totalExperience);
                        model.addAttribute("experience", experience);
                        model.addAttribute("profileForm", userService.createProfileForm(user));
                        model.addAttribute("unSelectedFlg", true);

                        return "quest/quest";
                }

                // 全て正答だった場合、次の大問用のformをセット
                // 正誤対象の大問ID+1で一覧から取得しformにセット
                model.addAttribute("words", words);
                model.addAttribute("processId", processId);
                model.addAttribute("questId", questId);
                model.addAttribute("problemForm",
                                questService.createProblemForm(processId, problem.getProblemNo() + 1));
                model.addAttribute("displayExperienceFlg", true);
                model.addAttribute("totalExperience", totalExperience);
                model.addAttribute("experience", experience);
                model.addAttribute("profileForm", userService.createProfileForm(user));
                model.addAttribute("unSelectedFlg", false);

                return "quest/quest";
        }

}