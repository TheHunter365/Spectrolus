package net.thehunter365.spectrolusconnector.protocol.packet.server;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class ServerKillPacket extends AbstractPacket {

    private String serverId;

    public ServerKillPacket(String serverId) {
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }
}
