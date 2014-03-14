package com.cemgunduz.utils.impl;

import com.cemgunduz.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by cgunduz on 3/14/14.
 */

@Component
public class RedisUtilsImpl implements RedisUtils {

    @Autowired
    Jedis redisTemplate;

    @PostConstruct
    public void init()
    {
        redisTemplate.connect();
    }

    @PreDestroy
    public void destroy()
    {
        redisTemplate.disconnect();
    }

    @Override
    public Jedis getRedisTemplate()
    {
        return redisTemplate;
    }
}
