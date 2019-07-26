package net.thehunter365.spectrolusconnector.protocol.decoder;

import com.google.gson.Gson;
import net.thehunter365.spectrolusconnector.protocol.event.EventManager;
import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;
import redis.clients.jedis.JedisPubSub;

public class PacketHandler extends JedisPubSub {

    private EventManager eventManager;
    private PacketDecoder packetDecoder;

    public PacketHandler(EventManager eventManager, Gson gson) {
        this.eventManager = eventManager;
        this.packetDecoder = new PacketDecoder(gson);
    }

    @Override
    public void onMessage(String channel, String message) {
        AbstractPacket packet = this.packetDecoder.decodePacket(message);
        PacketReceiveEvent event = new PacketReceiveEvent(channel, packet);
        this.eventManager.callPacketEvent(channel, event);
    }
}
