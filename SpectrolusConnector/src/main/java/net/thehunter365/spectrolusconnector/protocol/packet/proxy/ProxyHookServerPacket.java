package net.thehunter365.spectrolusconnector.protocol.packet.proxy;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class ProxyHookServerPacket extends AbstractPacket {

    private String name;
    private int port;

    public ProxyHookServerPacket(String name, int port) {
        this.name = name;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }
}
