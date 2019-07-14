package net.thehunter365.spectrolusconnector.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnection {




    private JedisPool jedisPool;

    public RedisConnection(String host, int port, String user, String pass) {

        JedisPoolConfig config = new JedisPoolConfig();
        //this.jedisPool = new JedisPool(new JedisPoolConfig(), host, port, user, pass);
        this.jedisPool = new JedisPool(config);
    }


    public Jedis getJedis() {
        return this.jedisPool.getResource();
    }
}
