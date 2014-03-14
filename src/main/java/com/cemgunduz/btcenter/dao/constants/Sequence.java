package com.cemgunduz.btcenter.dao.constants;

/**
 * Created by cgunduz on 3/14/14.
 */
public enum Sequence {

    ORDER("order_seq");

    private String redisKey;

    private Sequence(String redisKey)
    {
        this.redisKey = redisKey;
    }

    public String getRedisKey()
    {
        return redisKey;
    }
}
