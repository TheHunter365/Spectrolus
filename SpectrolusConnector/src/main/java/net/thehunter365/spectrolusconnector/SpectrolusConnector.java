package net.thehunter365.spectrolusconnector;

import com.google.gson.Gson;
import net.thehunter365.spectrolusconnector.protocol.ConnectionManager;
import net.thehunter365.spectrolusconnector.protocol.decoder.PacketHandler;
import net.thehunter365.spectrolusconnector.protocol.event.EventManager;
import net.thehunter365.spectrolusconnector.redis.RedisConnection;

public class SpectrolusConnector {


    private Gson gson;

    private RedisConnection redisConnection;
    private ConnectionManager connectionManager;
    private EventManager eventManager;

    public SpectrolusConnector(Gson gson) {
        this.gson = gson;
        this.redisConnection = new RedisConnection();
        this.connectionManager = new ConnectionManager(this.redisConnection.getJedis(), this.gson);
        this.eventManager = new EventManager();
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void startPacketHandler() {
        new Thread(()-> new PacketHandler(this.eventManager, this.gson));
    }

    public Gson getGson() {
        return gson;
    }

    public RedisConnection getRedisConnection() {
        return redisConnection;
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
}
