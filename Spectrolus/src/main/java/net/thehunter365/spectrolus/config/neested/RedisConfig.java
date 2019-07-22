package net.thehunter365.spectrolus.config.neested;

public class RedisConfig {

    private String hostname;
    private int port;

    public RedisConfig(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }
}
