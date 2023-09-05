package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Word;
import com.example.demo.entity.base.BaseRepository;

public interface WordRepository extends BaseRepository<Word, Long>{

    /**
     * 大問IDから用語一覧を取得します。
     * @param id 大問ID
     * @return 用語一覧
     */
    @Query("select distinct w from Word w"
            + " inner join w.problemWords p"
            + " inner join p.problem pr"
            + " where pr.id = :id") 
    public List<Word> findByProblemId(@Param("id") Long id);
    
}
