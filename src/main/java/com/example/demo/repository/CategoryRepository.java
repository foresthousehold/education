package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Category;
import com.example.demo.entity.base.BaseRepository;

public interface CategoryRepository extends BaseRepository<Category, Long> {

    /**
     * クエストIDからカテゴリID一覧を取得する
     */
    @Query("select c.id from Category c"
            + " inner join c.questCategories qc"
            + " inner join qc.quest q"
            + " where q.id = :id")
    public List<Long> findByCategoryId(@Param("id") Long id);
}
