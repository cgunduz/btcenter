package com.cemgunduz.btcenter.dao.impl;

import com.cemgunduz.btcenter.dao.SequenceRepository;
import com.cemgunduz.btcenter.dao.constants.Sequence;
import com.cemgunduz.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by cgunduz on 3/14/14.
 */
@Repository
public class SequenceRepositoryImpl implements SequenceRepository{

    @Autowired
    RedisUtils redisUtils;

    @Override
    public long nextSequence(Sequence sequence) {

        return redisUtils.getRedisTemplate().incr(sequence.getRedisKey());
    }
}
