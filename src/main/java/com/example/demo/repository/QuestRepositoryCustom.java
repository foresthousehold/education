package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Quest;
import com.example.demo.model.parameter.quest.SearchCriteria;

/**
 * クエストリポジトリカスタム
 */
public interface QuestRepositoryCustom {

    /**
     * 検索条件に基づき、削除されていないクエスト一覧を取得する。
     * @param searchCriteria
     * @return クエスト一覧
     */
    public List<Quest> search(SearchCriteria searchCriteria);
    
}
