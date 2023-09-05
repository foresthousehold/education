package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Problem;
import com.example.demo.entity.base.BaseRepository;

public interface ProblemRepository extends BaseRepository<Problem, Long>{

    /**
     * プロセスIDに紐づく大問一覧を取得します
     * @param id プロセスID
     * @param problemNo 大問ID
     */
    @Query("select distinct p from Problem p"
            + " where p.process.id = :id"
            + " and p.problemNo = :problemNo")
    public Optional<Problem> findByProcessIdAndProblemNo(@Param("id") Long id, @Param("problemNo") Long problemNo);
    
}
