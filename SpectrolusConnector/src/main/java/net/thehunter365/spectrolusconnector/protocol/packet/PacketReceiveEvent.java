package net.thehunter365.spectrolusconnector.protocol.packet;

import net.thehunter365.spectrolusconnector.protocol.event.Event;

public class PacketReceiveEvent extends Event {

    private String channel;
    private AbstractPacket packet;

    public PacketReceiveEvent(String channel, AbstractPacket packet) {
        this.channel = channel;
        this.packet = packet;
    }

    public String getChannel() {
        return channel;
    }

    public AbstractPacket getPacket() {
        return packet;
    }
}
