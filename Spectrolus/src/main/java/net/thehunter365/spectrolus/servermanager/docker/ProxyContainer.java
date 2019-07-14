package net.thehunter365.spectrolus.servermanager.docker;

public class ProxyContainer {

    private String remote;

    private String id;

    private String name;

    private int port;

    public ProxyContainer(String remote, String name, int port) {
        this.remote = remote;
        this.name = name;
        this.port = port;
    }


    public String getRemote() {
        return remote;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }

    public void setId(String id) {
        this.id = id;
    }
}
