package net.thehunter365.spectrolusconnector.protocol.packet.spectrolus;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class UpdateSpectroConfPacket extends AbstractPacket {


    private String jsonConf;

    public UpdateSpectroConfPacket(String jsonConf) {
        this.jsonConf = jsonConf;
    }

    public String getJsonConf() {
        return jsonConf;
    }
}
