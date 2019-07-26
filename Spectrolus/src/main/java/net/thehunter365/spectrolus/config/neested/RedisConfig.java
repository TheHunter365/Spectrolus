package net.thehunter365.spectrolus.config.neested;

public class RedisConfig {

    private String hostname;
    private int port;
    private String password;

    public RedisConfig(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        this.password = "";
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }
}
