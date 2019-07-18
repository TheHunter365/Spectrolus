package net.thehunter365.spectrolusconnector.protocol.packet.proxy;

public class ProxyAlertMessagePacket {

    private String id;

    private String message;

    public ProxyAlertMessagePacket(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
