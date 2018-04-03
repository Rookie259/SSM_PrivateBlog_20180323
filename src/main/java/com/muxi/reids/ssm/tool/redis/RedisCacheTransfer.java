package com.muxi.reids.ssm.tool.redis;/*
 *   @program: SSMspringMVC
 *   @description:静态注入中间类
 *   @Author: MuXi
 *   @create: 2018-03-17 16:27
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class RedisCacheTransfer {
    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
