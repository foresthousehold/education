package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Problem;
import com.example.demo.entity.base.BaseRepository;

public interface ProblemRepository extends BaseRepository<Problem, Long>{

    /**
     * クエストIDに紐づく大問一覧を取得します
     */
    @Query("select distinct p from Problem p"
            + " inner join p.quest q"
            + " where q.id = :id"
            + " order by p.id")
    public List<Problem> findByQuestId(@Param("id") Long id);
    
}
