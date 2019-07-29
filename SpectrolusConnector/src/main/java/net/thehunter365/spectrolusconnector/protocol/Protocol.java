package net.thehunter365.spectrolusconnector.protocol;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.common.HeartBeatPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.common.ServerEvacuatePacket;
import net.thehunter365.spectrolusconnector.protocol.packet.player.MapOrderPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyAlertMessagePacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyHookServerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyRemoveServerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyRoutePlayerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.server.ServerKillPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.server.ServerRequestPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.server.ServerStatePacket;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.AskForServiceDiscoveryPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.LogPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.ServiceDiscoveryPacket;

public enum Protocol {

    //All prupose
    HEART_BEAT_PACKET(1, HeartBeatPacket.class),

    //Proxying
    PROXY_ALERT_PACKET(2,ProxyAlertMessagePacket.class),
    PROXY_HOOK_SERVER_PACKET(3, ProxyHookServerPacket.class),
    PROXY_REMOVE_SERVER_PACKET(4, ProxyRemoveServerPacket.class),
    PROXY_ROUTE_PLAYER_PACKET(5, ProxyRoutePlayerPacket.class),

    //Server
    SERVER_REQUEST_PACKET(50, ServerRequestPacket.class),
    SERVER_STATE_PACKET(51, ServerStatePacket.class),
    SERVER_EVACUATE_PACKET(52, ServerEvacuatePacket.class),
    SERVER_KILL_PACKET(53, ServerKillPacket.class),

    //Player packets (for housing and skyblock)
    MAP_ORDER_PACKET(80, MapOrderPacket.class),

    //SpectroLogger
    LOG_PACKET(100, LogPacket.class),
    ASK_FOR_SERVICE_DISCOVERY_PACKET(101, AskForServiceDiscoveryPacket.class),
    SERVICE_DISCOVERY_PACKET(102, ServiceDiscoveryPacket.class),

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
