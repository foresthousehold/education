package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
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
public class QuestionService {

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
     * 大問フォームを作成します
     */
    public List<ProblemForm> createProblemForms(Long questId) {
        List<ProblemForm> problemForms =new ArrayList<>();

        // クエストIDに紐づく大問一覧を取得する
        List<Problem> problems = problemRepository.findByQuestId(questId);

        // 大問の数だけ回し、大問フォームに必要な値を詰める
        for(Problem problem : problems) {
            final ProblemForm problemForm = new ProblemForm();
            problemForm.setImgPaths(problem.getImages().stream().map(i -> i.getFilePath()).collect(Collectors.toList()));
            problemForm.setVideoPath(problem.getVideo().getFilePath());
            problemForm.setQuestionForms(createQuestionForms(problem.getId()));
            problemForms.add(problemForm);
        }

        return problemForms;
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
            answerChoiceForm.setContent(answerChoice.getContent());
            answerChoiceForm.setCorrectFlg(answerChoice.isCorrectFlg());
            answerChoiceForms.add(answerChoiceForm);
        }

        return answerChoiceForms;

    }
}
