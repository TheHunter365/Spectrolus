package net.thehunter365.spectrolusconnector.protocol.packet.proxy;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class ProxyRemoveServerPacket extends AbstractPacket {

    private String serverId;

    public ProxyRemoveServerPacket(String serverId) {
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }
}
