package net.thehunter365.spectrolusconnector.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.List;
import java.util.Set;

public class RedisConnection {

    private JedisPool jedisPool;
    private Jedis jedis;

    public RedisConnection(String host, int port, String pass) {
        JedisPoolConfig config = new JedisPoolConfig();
        this.jedisPool = new JedisPool(config, host, port, 300, pass);
        this.jedis = this.getJedis();
    }

    public RedisConnection() {
        JedisPoolConfig config = new JedisPoolConfig();
        this.jedisPool = new JedisPool(config, "redis", 6379);
        this.jedis = this.getJedis();
    }

    public RedisConnection(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        this.jedis = this.getJedis();
    }


    public void set(String key, String value) {
        this.jedis.set(key, value);
    }

    public String get(String key) {
        return this.jedis.get(key);
    }

    public Jedis getJedis() {
        return this.jedisPool.getResource();
    }

    public Pipeline pipelined() {
        return this.jedisPool.getResource().pipelined();
    }

    public List<Object> getValues(List<String> keys) {
        Pipeline pipeline = this.pipelined();
        keys.forEach(pipeline::get);
        return pipeline.syncAndReturnAll();
    }

    public List<Object> getAll() {
        Pipeline pipeline = this.pipelined();
        Set<String> keys = this.jedis.keys("'*'");
        keys.forEach(pipeline::get);
        return pipeline.syncAndReturnAll();
    }

}
