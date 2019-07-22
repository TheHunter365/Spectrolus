package net.thehunter365.spectrolus.config;

import net.thehunter365.spectrolus.config.neested.RedisConfig;
import net.thehunter365.spectrolus.config.neested.ServicesConfig;

public class Config {

    private RedisConfig redisConfig;
    private ServicesConfig servicesConfig;

    public Config() {
        this.redisConfig = new RedisConfig("localhost", 6397);
        this.servicesConfig = new ServicesConfig(2048);
    }

    public RedisConfig getRedisConfig() {
        return redisConfig;
    }

    public ServicesConfig getServicesConfig() {
        return servicesConfig;
    }
}
