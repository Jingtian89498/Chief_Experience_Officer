package com.ke.adc.chief_experience_officer.service.ranking;


import com.ke.adc.chief_experience_officer.dao.model.Rank;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.List;

public class RankServiceImpl implements RankService{
    Jedis jedis = null;
    @PostConstruct
    public void initRedisClient () {
        jedis = new Jedis("localhost", 6379);
    }
    @Override
    public Integer addScore(Integer id, Integer score) {
        return null;
    }

    @Override
    public List<Rank> searchRanking() {
        return null;
    }

    @Override
    public Integer useScore(Integer id) {
        return null;
    }


    /*void add(Integer id,Integer score){
        jedis.zincrby(Constants.SALES_LIST, score, String.valueOf(id));

    }
    void search(){
        Set<Tuple> tuples = jedis.zrevrangeWithScores(Constants.SALES_LIST, 0, 4);
        List<Rank> list = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Rank vo = new Rank();
            // 取出对应 phoneId 的手机名称
            int phoneId = Integer.parseInt(tuple.getElement());
            vo.setName(phones.get(phoneId - 1).getName());
            vo.setSales((int) tuple.getScore());
            list.add(vo);
        }
        return list;
    }
    void delete(){

    }*/
}
