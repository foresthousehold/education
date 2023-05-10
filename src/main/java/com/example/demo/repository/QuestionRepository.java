package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Question;
import com.example.demo.entity.base.BaseRepository;

/**
 * 問題レポジトリ
 */
public interface QuestionRepository extends BaseRepository<Question, Long>{

    /**
     * 大問IDから小問一覧を取得します
     * @param id 大問ID
     * @return 小問一覧
     */
    @Query("select q from Question q"
            + " inner join q.problem p"
            + " where p.id = :id")
    public List<Question> findByProblemId(@Param("id") Long id);
    
}
