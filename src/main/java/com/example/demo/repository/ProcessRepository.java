package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Process;
import com.example.demo.entity.base.BaseRepository;


public interface ProcessRepository extends BaseRepository<Process, Long> {

    /**
     * クエストIDに紐づくプロセス一覧を取得します。
     * @param id クエストID
     */
    @Query("select p from Process p"
            + " inner join p.quest q"
            + " where q.id = :id")
    public List<Process> findByQuestId(@Param("id") Long id);
    
}
