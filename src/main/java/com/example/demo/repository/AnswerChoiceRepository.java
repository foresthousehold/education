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


}
