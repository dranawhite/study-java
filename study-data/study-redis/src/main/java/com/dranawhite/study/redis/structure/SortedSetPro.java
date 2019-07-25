package com.dranawhite.study.redis.structure;

import com.dranawhite.study.redis.factory.RedisFactory;

import redis.clients.jedis.Jedis;

/**
 *
 * @author dranawhite
 * @version : SortedSetPro.java, v 0.1 2019-07-25 9:44 dranawhite Exp $$
 */
public class SortedSetPro {

    private Jedis jedis = RedisFactory.getJedis();

    void zadd(int member) {
        long num = jedis.zadd("study.redis.sortedSet", member, String.valueOf(member));
    }

    Double zscore(String member) {
        // 返回member的分数，若member不存在，则返回null;
        return jedis.zscore("study.redis.sortedSet", member);
    }

    public static void main(String[] args) {
        SortedSetPro pro = new SortedSetPro();
        pro.zadd(11);
        Double score_11 = pro.zscore("11");
        Double score_12 = pro.zscore("12");
        System.out.println("11: " + score_11);
        System.out.println("12: " + score_12);
    }
}
