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
public class QuestRepositoryCustomImpl implements QuestRepositoryCustom {

    /** データベースにアクセスする際に必要 */
    @Autowired
    EntityManager em;

    @Override
    public List<Quest> search(SearchCriteria searchCriteria) {

        final String findQueryHead = "select distinct q from Quest q"
                + " inner join q.dish d"
                + " left join q.questCategories qc"
                + " inner join qc.category c";

        StringBuilder dishQuery = new StringBuilder()
                // .append(" where q.deleteFlg = false")
                .append(" where ")
                .append(QueryUtil.optionalQuery(SearchCriteria.DISH_ID_KEY, "d.id = :dishId",
                        searchCriteria.getDishId()))
                .append(QueryUtil.createQuery(SearchCriteria.CATEGORY_ID_1_KEY, "c.id = :categoryId1",
                        searchCriteria.getCategoryId1()));
        // .append(" or
        // ").append(QueryUtil.optionalQuery(SearchCriteria.CATEGORY_ID_2_KEY, "c.id =
        // :categoryId2)"))

        final String findQueryStr = new StringBuilder(findQueryHead).append(dishQuery.toString()).toString();

        final TypedQuery<Quest> findQuery = em.createQuery(findQueryStr, Quest.class);

        searchCriteria.createBindParams().forEach((key, param) -> {
            findQuery.setParameter(key, param);
        });

        final List<Quest> quests = findQuery.getResultList();

        return quests;
    }

}
