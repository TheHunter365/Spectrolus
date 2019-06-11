package net.thehunter365.spectrolus.servermanager.docker;

public class ProxyContainer {

    private String remote;
    private String id;
    private String name;

    public ProxyContainer(String remote, String id, String name) {
        this.remote = remote;
        this.id = id;
        this.name = name;
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
}
