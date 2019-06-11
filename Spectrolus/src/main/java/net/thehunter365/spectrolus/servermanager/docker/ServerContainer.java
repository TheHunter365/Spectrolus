package net.thehunter365.spectrolus.servermanager.docker;

public class ServerContainer {

    private String remote;

    private String id;

    private String name;

    private String minigame;
    private String map;

    private int port;

    public ServerContainer(String remote, String name, String minigame, String map, int port) {
        this.remote = remote;
        this.name = name;
        this.minigame = minigame;
        this.map = map;
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMinigame() {
        return minigame;
    }

    public String getMap() {
        return map;
    }

    public int getPort() {
        return port;
    }

    public String getRemote() {
        return remote;
    }

    public void setId(String id) {
        this.id = id;
    }
}
