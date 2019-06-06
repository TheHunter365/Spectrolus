package net.thehunter365.spectrolus.servermanager.docker;

import net.thehunter365.spectrolus.utils.IdGenerator;

public class ProxyContainer {

    private String id;
    private int port;

    public ProxyContainer(int port) {
        this.id = IdGenerator.getId();
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public int getPort() {
        return port;
    }
}
