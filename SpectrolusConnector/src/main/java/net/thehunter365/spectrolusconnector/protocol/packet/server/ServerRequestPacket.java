package net.thehunter365.spectrolusconnector.protocol.packet.server;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class ServerRequestPacket extends AbstractPacket {

    private String type;
    private String map;

    public ServerRequestPacket(String type, String map) {
        this.type = type;
        this.map = map;
    }

    public String getType() {
        return type;
    }

    public String getMap() {
        return map;
    }
}
