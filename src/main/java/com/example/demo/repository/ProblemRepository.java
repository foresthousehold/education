package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Problem;
import com.example.demo.entity.base.BaseRepository;

public interface ProblemRepository extends BaseRepository<Problem, Long>{

    /**
     * クエストIDに紐づく大問一覧を取得します
     */
    @Query("select distinct p from Problem p"
            + " where p.quest.id = :id"
            + " and p.problemNo = :problemNo")
    public Optional<Problem> findByQuestIdAndProblemNo(@Param("id") Long id, @Param("problemNo") Long problemNo);
    
}
