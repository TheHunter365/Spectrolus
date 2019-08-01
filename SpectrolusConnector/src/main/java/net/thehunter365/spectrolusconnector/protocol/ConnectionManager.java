package net.thehunter365.spectrolusconnector.protocol;

import com.google.gson.Gson;
import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.stream.Collectors;

public class ConnectionManager {

    private String defaultChannel = "Spectrolus";

    private Gson gson;
    private Jedis jedis;


    public ConnectionManager(Jedis jedis, Gson gson) {
        this.jedis = jedis;
        this.gson = gson;
        this.jedis.select(2);
    }

    public void addChannel(String type, String id) {
        this.jedis.sadd("channels", type+"-"+id);
    }

    public void sendPacket(AbstractPacket packet) {
        this.sendPacket(this.defaultChannel, packet);
    }

    public void sendPacket(String channel, AbstractPacket packet) {
        this.jedis.publish(channel, this.gson.toJson(packet));
    }

    public Set<String> getChannelsByType(String type) {
        return this.jedis.smembers("channels").stream()
                .filter(channel -> channel.split("-")[0].equals(type))
                .collect(Collectors.toSet());
    }

    public Set<String> getRegisteredChannels() {
        return this.jedis.smembers("channels");
    }


}
