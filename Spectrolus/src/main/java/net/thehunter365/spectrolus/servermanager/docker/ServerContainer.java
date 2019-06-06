package net.thehunter365.spectrolus.servermanager.docker;

import net.thehunter365.spectrolus.utils.IdGenerator;

public class ServerContainer {

    private String id;
    private String minigame;
    private String map;
    private int port;

    public ServerContainer(String minigame, String map, int port) {
        this.id = IdGenerator.getId();
        this.minigame = minigame;
        this.map = map;
        this.port = port;
    }

    public String getId() {
        return id;
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
}
