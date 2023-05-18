package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.AnswerChoice;
import com.example.demo.entity.base.BaseRepository;

public interface AnswerChoiceRepository extends BaseRepository<AnswerChoice, Long>{

    /**
     * 小問IDに紐づく解答選択肢を取得します
     */
    @Query("select a from AnswerChoice a"
            + " inner join a.question q"
            + " where q.id = :id")
    public List<AnswerChoice> findByQuestionId(@Param("id") Long id); 

    /**
     * 小問IDに紐づく正答フラグがtrueの選択肢IDを取得します
     */
    @Query("select a.id from AnswerChoice a"
            + " inner join a.question q"
            + " where q.id = :id"
            + " and a.correctFlg = true")
    public Long findByQuestionIdAndCorrectFlg(@Param("id") Long id);
}
