package net.thehunter365.spectrolusconnector;

import com.google.gson.Gson;
import net.thehunter365.spectrolusconnector.redis.RedisConnection;

public class SpectrolusConnector {


    private Gson gson;

    private RedisConnection connection;

    public SpectrolusConnector(Gson gson) {
        this.gson = gson;
        this.connection = new RedisConnection("localhost", 6379, "me", "you");
    }

    public Gson getGson() {
        return gson;
    }

    public RedisConnection getConnection() {
        return connection;
    }
}
