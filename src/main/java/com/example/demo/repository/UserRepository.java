package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.entity.base.BaseRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends BaseRepository<User, Long> {

}