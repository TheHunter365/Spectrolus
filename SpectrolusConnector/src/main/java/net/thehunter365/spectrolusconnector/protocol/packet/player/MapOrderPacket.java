package net.thehunter365.spectrolusconnector.protocol.packet.player;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class MapOrderPacket extends AbstractPacket {

    private String mapId;

    public MapOrderPacket(String mapId) {
        this.mapId = mapId;
    }

    public String getMapId() {
        return mapId;
    }
}
