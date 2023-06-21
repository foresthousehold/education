package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AnswerChoice;
import com.example.demo.entity.Problem;
import com.example.demo.entity.Question;
import com.example.demo.model.form.AnswerChoiceForm;
import com.example.demo.model.form.ProblemForm;
import com.example.demo.model.form.QuestionForm;
import com.example.demo.model.form.QuizForm;
import com.example.demo.repository.AnswerChoiceRepository;
import com.example.demo.repository.ProblemRepository;
import com.example.demo.repository.QuestionRepository;

/**
 * 問題サービス
 */
@Service
public class QuestService {

    @Autowired ProblemRepository problemRepository;

    @Autowired QuestionRepository questionRepository;

    @Autowired AnswerChoiceRepository answerChoiceRepository;
    
    /**
     * クイズフォームを作成します
     */
    public QuizForm createQuizForm(QuizForm quizForm) {
        
        return quizForm;
    }

    /**
     * 最初の大問フォームを作成します
     */
    public ProblemForm createFirstProblemForm(Long questId) {

        return createProblemForm(questId, 1L);
    }

    /**
     * 大問フォームを作成します
     */
    public ProblemForm createProblemForm(Long questId, Long problemNo) {

        // クエストIDに紐づく一番初めの大問を取得する
        Problem problem = problemRepository.findByQuestIdAndProblemNo(questId, problemNo).orElseThrow();

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
    public ProblemForm createProblemForm(Long questId, ProblemForm problemForm) {

        // クエストIDに紐づく一番初めの大問を取得する
        Problem problem = problemRepository.findByQuestIdAndProblemNo(questId, problemForm.getProblemNo()).orElseThrow();

        final ProblemForm updateProblemForm = new ProblemForm();
        updateProblemForm.setProblemNo(problem.getProblemNo());
        updateProblemForm.setImgPaths(problem.getImages().stream().map(i -> i.getFilePath()).collect(Collectors.toList()));
        updateProblemForm.setVideoPath(problem.getVideo().getFilePath());
        updateProblemForm.setQuestionForms(createQuestionForms(problem.getId(), problemForm));

        return updateProblemForm;
    }

    /**
     * 問題フォームを作成します
     */
    public List<QuestionForm> createQuestionForms(Long problemId, ProblemForm problemForm) {
        final List<QuestionForm> questionForms = new ArrayList<>();

        // 大問IDに紐づく全ての小問を取得する
        final List<Question> questions = questionRepository.findByProblemId(problemId);

        // 小問ごとに解答選択フォームを作成する
        for(int i = 0;  i < questions.size(); i++) {
            Question question = questions.get(i);
            QuestionForm questionForm = new QuestionForm();
            questionForm.setQuestionId(question.getId());
            questionForm.setChoicedAnswerId(problemForm.getQuestionForms().get(i).getChoicedAnswerId());
            questionForm.setAnswerChoiceForms(createAnswerChoiceForms(question.getId()));

            // 小問IDに紐づく全ての解答選択肢を取得する
            final List<AnswerChoice> answerChoices = answerChoiceRepository.findByQuestionId(question.getId());

            // 入ってきた選択肢IDとアドバイスのmap作成
            Map<Long, String> answerChoiceIdMap = answerChoices.stream().collect(Collectors.toMap(
                AnswerChoice::getId,
                AnswerChoice::getAdvice
            ));

            questionForm.setAdvice(answerChoiceIdMap.get(problemForm.getQuestionForms().get(i).getChoicedAnswerId()));

            questionForms.add(questionForm);
        }
        
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
        for(Question question : questions) {
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
        for(AnswerChoice answerChoice : answerChoices) {
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
}
