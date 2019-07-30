package net.thehunter365.spectrolusconnector.protocol.packet.common;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class HeartBeatPacket extends AbstractPacket {


    private String id;
    private String payload;

    public HeartBeatPacket(String id, String payload) {
        this.id = id;
        this.payload = payload;
    }

    public HeartBeatPacket(String id) {
        this.id = id;
        this.payload = "";
    }

    public String getPayload() {
        return payload;
    }

    public String getId() {
        return id;
    }

}
