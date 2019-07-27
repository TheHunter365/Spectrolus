package net.thehunter365.spectrolusconnector.protocol.packet.common;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class ServerEvacuatePacket extends AbstractPacket {

    private String serverId;
    private String destinationId;

    public ServerEvacuatePacket(String serverId, String destinationId) {
        this.serverId = serverId;
        this.destinationId = destinationId;
    }

    public String getServerId() {
        return serverId;
    }

    public String getDestinationId() {
        return destinationId;
    }
}
