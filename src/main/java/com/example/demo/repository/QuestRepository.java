package com.example.demo.repository;

import com.example.demo.entity.Quest;
import com.example.demo.entity.base.BaseRepository;

public interface QuestRepository extends BaseRepository<Quest, Long>, QuestRepositoryCustom{
    
}
