package net.thehunter365.spectrolusconnector.protocol.packet;

public class HeartBeatPacket extends AbstractPacket {


    private String id;

    public HeartBeatPacket(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
