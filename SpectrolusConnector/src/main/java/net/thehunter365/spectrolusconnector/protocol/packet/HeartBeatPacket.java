package net.thehunter365.spectrolusconnector.protocol.packet;

public class HeartBeatPacket extends AbstractPacket {


    private String type;
    private String id;

    public HeartBeatPacket(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
