package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;
import com.example.demo.entity.base.BaseRepository;

/**
 * 利用者リポジトリ
 */
public interface UserRepository extends BaseRepository<User, Long> {

    @Query("select u from User u"
            + " where u.username = :username")
    public Optional<User> findByUserName(@Param("username") String username);

    @Query("select u from User u"
            + " order by u.level desc")
    public List<User> findAllSortByLevel();

}
