package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Experience;
import com.example.demo.entity.base.BaseRepository;

public interface ExperienceRepository extends BaseRepository<Experience, Long>{

        /**
         * ユーザの累積経験値とクエストが持つ経験値の合計に近い経験値エンティティを取得します。
         */
        @Query("select e from Experience e" 
                + " order by abs(e.needTotalExperience - :totalExperience) ASC")
        public List<Experience> findByTotalExperience(@Param("totalExperience") Long totalExperience);
}