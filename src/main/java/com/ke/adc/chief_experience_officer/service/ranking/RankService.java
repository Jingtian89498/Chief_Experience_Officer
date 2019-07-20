package com.ke.adc.chief_experience_officer.service.ranking;

import com.ke.adc.chief_experience_officer.dao.model.Rank;

import java.util.List;

public interface RankService {
    Integer addScore(Integer id,Integer score);
    List<Rank> searchRanking();
    Integer useScore(Integer id);
}
