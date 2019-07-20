package net.thehunter365.spectrolusconnector.protocol.packet.proxy;

import java.util.UUID;

public class ProxyRoutePlayerPacket {

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
