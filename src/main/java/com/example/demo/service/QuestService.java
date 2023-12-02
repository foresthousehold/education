package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AnswerChoice;
import com.example.demo.entity.Experience;
import com.example.demo.entity.Problem;
import com.example.demo.entity.Process;
import com.example.demo.entity.Quest;
import com.example.demo.entity.Question;
import com.example.demo.entity.User;
import com.example.demo.model.form.AnswerChoiceForm;
import com.example.demo.model.form.ProblemForm;
import com.example.demo.model.form.QuestForm;
import com.example.demo.model.form.QuestionForm;
import com.example.demo.model.form.QuizForm;
import com.example.demo.model.form.SearchForm;
import com.example.demo.model.parameter.quest.SearchCriteria;
import com.example.demo.repository.AnswerChoiceRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.ExperienceRepository;
import com.example.demo.repository.ProblemRepository;
import com.example.demo.repository.ProcessRepository;
import com.example.demo.repository.QuestRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.UserRepository;

/**
 * 問題サービス
 */
@Service
public class QuestService {

    @Autowired
    AnswerChoiceRepository answerChoiceRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    DishRepository dishRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    /** 継承 */
    private static final Long EXTEND = 1L;

    /** インターフェース */
    private static final Long INTERFACE = 2L;

    /** クラス */
    private static final Long CLASS = 3L;

    /**
     * クイズフォームを作成します
     */
    public QuizForm createQuizForm(QuizForm quizForm) {

        return quizForm;
    }

    /**
     * 最初の大問フォームを作成します
     */
    public ProblemForm createFirstProblemForm(Long processId) {

        return createProblemForm(processId, 1L);
    }

    /**
     * 大問フォームを作成します
     */
    public ProblemForm createProblemForm(Long processId, Long problemNo) {

        // クエストIDに紐づく一番初めの大問を取得する
        Problem problem = problemRepository.findByProcessIdAndProblemNo(processId, problemNo).orElseThrow();

        final ProblemForm problemForm = new ProblemForm();
        problemForm.setProblemNo(problem.getProblemNo());
        problemForm.setImgPaths(problem.getImages().stream().map(i -> i.getFilePath()).collect(Collectors.toList()));
        problemForm.setVideoPath(problem.getVideo().getFilePath());
        problemForm.setQuestionForms(createQuestionForms(problem.getId()));

        return problemForm;
    }

    /**
     * 受け取ったクエストIDとproblemFormから値を受け取って返す。
     */
    public ProblemForm createProblemForm(Long questId, ProblemForm problemForm,
            List<QuestionForm> filteredQuestionForms) {

        // クエストIDに紐づく一番初めの大問を取得する
        Problem problem = problemRepository.findByProcessIdAndProblemNo(questId, problemForm.getProblemNo())
                .orElseThrow();

        final ProblemForm updateProblemForm = new ProblemForm();
        updateProblemForm.setProblemNo(problem.getProblemNo());
        updateProblemForm
                .setImgPaths(problem.getImages().stream().map(i -> i.getFilePath()).collect(Collectors.toList()));
        updateProblemForm.setVideoPath(problem.getVideo().getFilePath());
        updateProblemForm.setQuestionForms(createQuestionForms(problem.getId(), problemForm, filteredQuestionForms));

        return updateProblemForm;
    }

    /**
     * 問題フォームを作成します
     */
    public List<QuestionForm> createQuestionForms(Long problemId, ProblemForm problemForm,
            List<QuestionForm> filteredQuestionForms) {
        final List<QuestionForm> questionForms = new ArrayList<>();

        // 大問IDに紐づく全ての小問を取得する
        final List<Question> questions = questionRepository.findByProblemId(problemId);

        // 小問ごとに解答選択フォームを作成する
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            QuestionForm questionForm = new QuestionForm();
            questionForm.setQuestionId(question.getId());
            questionForm.setChoicedAnswerId(problemForm.getQuestionForms().get(i).getChoicedAnswerId());
            questionForm.setAnswerChoiceForms(createAnswerChoiceForms(question.getId()));
            questionForm.setCorrectFlg(true);

            // 小問IDに紐づく全ての解答選択肢を取得する
            final List<AnswerChoice> answerChoices = answerChoiceRepository.findByQuestionId(question.getId());

            // 入ってきた選択肢IDとアドバイスのmap作成
            Map<Long, String> answerChoiceIdMap = answerChoices.stream().collect(Collectors.toMap(
                    AnswerChoice::getId,
                    AnswerChoice::getAdvice));

            questionForm.setAdvice(answerChoiceIdMap.get(problemForm.getQuestionForms().get(i).getChoicedAnswerId()));

            questionForms.add(questionForm);
        }

        List<Long> filteredQuestionFormIds = filteredQuestionForms.stream().map(q -> q.getQuestionId())
                .collect(Collectors.toList());

        // 引数のquestionFormsごと回して作成したformsの中から一致するform一覧を取得する。
        // 取得したformsごとに正答フラグをfalseにする。
        questionForms.stream()
                .filter(q -> filteredQuestionFormIds.contains(q.getQuestionId()))
                .forEach(q -> q.setCorrectFlg(false));

        return questionForms;
    }

    /**
     * 問題フォームを作成します
     */
    public List<QuestionForm> createQuestionForms(Long problemId) {
        final List<QuestionForm> questionForms = new ArrayList<>();

        // 大問IDに紐づく全ての小問を取得する
        final List<Question> questions = questionRepository.findByProblemId(problemId);

        // 小問ごとに解答選択フォームを作成する
        for (Question question : questions) {
            QuestionForm questionForm = new QuestionForm();
            questionForm.setQuestionId(question.getId());
            questionForm.setAnswerChoiceForms(createAnswerChoiceForms(question.getId()));
            questionForms.add(questionForm);
        }

        return questionForms;
    }

    /**
     * 解答選択フォームを作成します
     */
    public List<AnswerChoiceForm> createAnswerChoiceForms(Long questionId) {
        final List<AnswerChoiceForm> answerChoiceForms = new ArrayList<>();

        // 小問IDに紐づく全ての解答選択肢を取得する
        final List<AnswerChoice> answerChoices = answerChoiceRepository.findByQuestionId(questionId);

        // 解答選択肢ごとにフォームにセットする
        for (AnswerChoice answerChoice : answerChoices) {
            AnswerChoiceForm answerChoiceForm = new AnswerChoiceForm();
            answerChoiceForm.setId(answerChoice.getId());
            answerChoiceForm.setContent(answerChoice.getContent());
            answerChoiceForms.add(answerChoiceForm);
        }

        return answerChoiceForms;
    }

    /**
     * key: questionId, Value: 正解の選択肢Idのマップを作成します
     */
    public Map<Long, Long> createAnswerChoiceIdMap(List<Question> questions) {
        Map<Long, Long> createAnswerChoiceIdMap = questions.stream()
                .collect(Collectors.toMap(
                        Question::getId,
                        q -> answerChoiceRepository.findByQuestionIdAndCorrectFlg(q.getId())));

        return createAnswerChoiceIdMap;
    }

    /**
     * key: 合計経験値, value: レベルのマップを作成します
     */
    public Map<Long, Long> createExperienceMap() {
        Map<Long, Long> experienceMap = new HashMap<>();

        final List<Experience> experiences = experienceRepository.findAll();
        experienceMap = experiences.stream()
                .collect(Collectors.toMap(e -> e.getNeedTotalExperience(), e -> e.getLevel()));

        return experienceMap;
    }

    /**
     * ユーザのレベルを上げ保存します。
     */
    @Transactional
    public void updateUserLevel(User user, Long experience) {
        final Long totalExperience = user.getTotalExperience() + experience;
        final Experience entity = experienceRepository.findByTotalExperience(user.getTotalExperience() + experience)
                .stream().findFirst().orElse(null);

        user.setLevel(entity.getLevel());
        user.setTotalExperience(totalExperience);
        userRepository.save(user);
    }

    /**
     * プロセスのフラグを更新します。
     * 
     * @param processId プロセスID
     */
    @Transactional
    public void updateAccessFlg(Long processId) {
        // Todo: Optional型に修正
        final Optional<Process> process = processRepository.findById(processId);
        if (process.isPresent()) {
            process.get().setAccessFlg(true);
            processRepository.save(process.get());
        }
    }

    /**
     * 検索フォームを作成します。
     */
    public SearchForm createSearchForm() {
        SearchForm searchForm = new SearchForm();
        searchForm.setDishes(dishRepository.findAll());
        searchForm.setCategories1(categoryRepository.findAll());
        searchForm.setCategories2(categoryRepository.findAll());
        return searchForm;
    }

    /**
     * 検索条件を作成します
     */
    public SearchCriteria createSearchCriteria(SearchForm searchForm) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setDishId(searchForm.getDishId());
        searchCriteria.setCategoryId1(searchForm.getCategoryId1());
        searchCriteria.setCategoryId2(searchForm.getCategoryId2());
        return searchCriteria;
    }

    /**
     * クエストフォームを作成します
     */
    public QuestForm createQuestForm(Quest quest) {
        QuestForm questForm = new QuestForm();
        // クエストからクエストカテゴリーにアクセスし、紐づくカテゴリーIDを全て取得
        List<Long> categoryIds = categoryRepository.findByCategoryId(quest.getId());
        questForm.setQuest(quest);

        categoryIds.stream().forEach(id -> {
            if (id == EXTEND) {
                questForm.setExtendFlg(true);
            }
            if (id == INTERFACE) {
                questForm.setInterfaceFlg(true);
            }
        });
        return questForm;
    }
}