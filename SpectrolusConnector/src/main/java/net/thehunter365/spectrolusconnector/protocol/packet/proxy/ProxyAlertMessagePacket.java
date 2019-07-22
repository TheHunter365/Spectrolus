package net.thehunter365.spectrolusconnector.protocol.packet.proxy;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class ProxyAlertMessagePacket extends AbstractPacket {

    private String message;

    public ProxyAlertMessagePacket(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
