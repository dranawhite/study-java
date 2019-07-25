package com.dranawhite.study.redis.factory;

import redis.clients.jedis.Jedis;

/**
 *
 * @author dranawhite
 * @version : RedisFactory.java, v 0.1 2019-07-25 9:45 dranawhite Exp $$
 */
public class RedisFactory {

    private static Jedis jedis;

    private static final String REDIS_HOST = "127.0.0.1";
    private static final int REDIS_PORT = 6379;

    public static Jedis getJedis() {
        if (jedis == null) {
            jedis = new Jedis(REDIS_HOST, REDIS_PORT);
        }
        return jedis;
    }
}
