package net.thehunter365.spectrolusconnector.protocol.packet.proxy;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

import java.util.UUID;

public class ProxyRoutePlayerPacket extends AbstractPacket {

    private String serverId;

    private UUID playerUuid;

    public ProxyRoutePlayerPacket(String serverId, UUID playerUuid) {
        this.serverId = serverId;
        this.playerUuid = playerUuid;
    }

    public String getServerId() {
        return serverId;
    }

    public UUID getPlayerUuid() {
        return playerUuid;
    }
}
