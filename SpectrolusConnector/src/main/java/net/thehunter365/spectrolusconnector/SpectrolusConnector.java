package net.thehunter365.spectrolusconnector;

import com.google.gson.Gson;
import net.thehunter365.spectrolusconnector.protocol.event.EventManager;
import net.thehunter365.spectrolusconnector.redis.RedisConnection;

public class SpectrolusConnector {


    private Gson gson;

    private RedisConnection connection;
    private EventManager eventManager;

    public SpectrolusConnector(Gson gson) {
        this.gson = gson;
        this.connection = new RedisConnection();

        this.eventManager = new EventManager();
    }

    public void startEventListening() {

    }

    public Gson getGson() {
        return gson;
    }

    public RedisConnection getConnection() {
        return connection;
    }
}
