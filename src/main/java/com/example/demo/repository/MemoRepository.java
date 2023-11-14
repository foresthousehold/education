package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Memo;
import com.example.demo.entity.base.BaseRepository;

@Repository
public interface MemoRepository extends BaseRepository<Memo, Long> {

    /**
     * ユーザIDに紐づく削除されていないメモを取得します。
     */
    @Query("select m from Memo m"
            + " inner join m.user u"
            + " where u.id = :id"
            + " and m.deleteFlg = false")
    public List<Memo> findByUserId(@Param("id") Long id);
}
