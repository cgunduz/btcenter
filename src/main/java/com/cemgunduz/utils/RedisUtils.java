package com.cemgunduz.utils;

import redis.clients.jedis.Jedis;

/**
 * Created by cgunduz on 3/14/14.
 */
public interface RedisUtils {

    public Jedis getRedisTemplate();
}
