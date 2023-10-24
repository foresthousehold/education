package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Util.QueryUtil;
import com.example.demo.entity.Quest;
import com.example.demo.model.parameter.quest.SearchCriteria;

/**
 * クエストリポジトリカスタム実装
 */
public class QuestRepositoryCustomImpl implements QuestRepositoryCustom{

    /** データベースにアクセスする際に必要 */
    @Autowired
    EntityManager em;

    @Override
    public List<Quest> search(SearchCriteria searchCriteria) {

        final String findQueryHead = "select q from Quest q"
                + " inner join fetch q.dish d";

        StringBuilder dishQuery = new StringBuilder()
            // .append(" where q.deleteFlg = false")
            .append(" where d.id = ").append(QueryUtil.nullSafeQuery(searchCriteria.getDishId(), SearchCriteria.DISH_ID_KEY));

        final String findQueryStr = new StringBuilder(findQueryHead).append(dishQuery.toString()).toString();

        final TypedQuery<Quest> findQuery = em.createQuery(findQueryStr, Quest.class);

        searchCriteria.createBindParams().forEach((key, param) -> {
            findQuery.setParameter(key, param);
        });

        final List<Quest> quests = findQuery.getResultList();

        return quests;
    }
    
}
