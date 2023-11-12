package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserLogin;
import com.example.demo.entity.base.BaseRepository;

@Repository
public interface UserLoginRepository extends BaseRepository<UserLogin, Long> {

	/**
	 * ユーザIDと日付からユーザログインを取得する
	 */
	@Query("select ul from UserLogin ul"
			+ " inner join ul.user u"
			+ " where u.id = :id"
			+ " and ul.loginDate = :currentDate"
			+ " and ul.deleteFlg = false")
	public Optional<UserLogin> findByUserIdAndCurrentDate(@Param("id") Long id,
			@Param("currentDate") LocalDate currentDate);

	/**
	 * ユーザIDから全てのユーザログインを取得する
	 */
	@Query("select ul.loginDate from UserLogin ul"
			+ " inner join ul.user u"
			+ " where u.id = :id")
	public List<LocalDate> findByUserId(@Param("id") Long id);
}
