package com.ke.adc.chief_experience_officer.service.ranking;

import com.ke.adc.chief_experience_officer.dao.model.Rank;

import java.util.List;


public interface RedisService {

    Integer add(Integer id,Integer score);
    List<Rank> search();

}
