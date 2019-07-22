package net.thehunter365.spectrolusconnector.protocol;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.HeartBeatPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyAlertMessagePacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyHookServerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyRemoveServerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyRoutePlayerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.server.ServerRequestPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.server.ServerStatePacket;

public enum Protocol {

    HEART_BEAT_PACKET(1, HeartBeatPacket.class),

    PROXY_ALERT_PACKET(2,ProxyAlertMessagePacket.class),
    PROXY_HOOK_SERVER_PACKET(3, ProxyHookServerPacket.class),
    PROXY_REMOVE_SERVER_PACKET(4, ProxyRemoveServerPacket.class),
    PROXY_ROUTE_PLAYER_PACKET(5, ProxyRoutePlayerPacket.class),

    SERVER_REQUEST_PACKET(10, ServerRequestPacket.class),
    SERVER_STATE_PACKET(11, ServerStatePacket.class)
    ;
    public static final String SPLIT_CHAR = "&";

    private int packetId;
    private Class<? extends AbstractPacket> packetClass;

    Protocol(int packetId, Class<? extends AbstractPacket> packetClass) {
        this.packetId = packetId;
        this.packetClass = packetClass;
    }

    public Class<? extends AbstractPacket> getPacketClass() {
        return packetClass;
    }

    public int getPacketId() {
        return packetId;
    }

    public static int getPacketId(AbstractPacket abstractPacketClass) {
        int id = -1;
        for (Protocol p : values()) {
            if (p.getPacketClass().equals(abstractPacketClass.getClass())) {
                id = p.getPacketId();
                break;
            }
        }

        return id;
    }

    public static Class<? extends AbstractPacket> getPacketClass(int id) {
        Class<? extends AbstractPacket> packetClass = null;
        for (Protocol protocol : values()) {
            if (protocol.getPacketId() == id) {
                packetClass = protocol.getPacketClass();
                break;
            }
        }

        return packetClass;
    }
}
