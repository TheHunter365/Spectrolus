package net.thehunter365.spectrolusconnector.protocol.packet.spectrologger;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class AskForServiceDiscoveryPacket extends AbstractPacket {

    private String channel;

    public AskForServiceDiscoveryPacket(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }
}
