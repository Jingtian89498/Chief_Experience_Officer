package com.ke.adc.chief_experience_officer.service.ranking;


import com.ke.adc.chief_experience_officer.dao.model.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankServiceImpl implements RankService{

    @Autowired
    private RedisService redisService;
    @Override
    public Integer addScore(Integer id, Integer score) {
        //写库

        redisService.add(id,score);
        return 1;
    }

    @Override
    public List<Rank> searchRanking() {
        List<Rank> ret=redisService.search();
        return ret;
    }

    @Override
    public Integer useScore(Integer id,Integer score) {
        return null;
    }


}
