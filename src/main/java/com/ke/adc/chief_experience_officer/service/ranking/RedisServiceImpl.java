package com.ke.adc.chief_experience_officer.service.ranking;

import com.ke.adc.chief_experience_officer.dao.model.Rank;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisServiceImpl implements RedisService {

    private Jedis jedis = null;
    @PostConstruct
    public void initRedisClient () {
        jedis = new Jedis("localhost", 6379);
    }

    @Override
    public Integer add(Integer id, Integer score) {
        jedis.zincrby("Rank", score, String.valueOf(id));
        return 1;
    }

    @Override
    public List<Rank> search() {
        Set<Tuple> tuples = jedis.zrevrangeWithScores("Rank", 0, 4);
        List<Rank> list = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Rank rank = new Rank();
            int id = Integer.parseInt(tuple.getElement());
            int score=(int)tuple.getScore();
            rank.setUserId(id);
            rank.setScoreTotal(score);
            //rank.setUserName();
            list.add(rank);
        }

        return list;
    }
}
