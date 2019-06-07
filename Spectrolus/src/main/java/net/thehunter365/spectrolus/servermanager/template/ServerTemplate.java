package net.thehunter365.spectrolus.servermanager.template;

import java.util.ArrayList;
import java.util.List;

public class ServerTemplate {

    private String minigame;
    private String containerId;

    private List<String> maps;

    public ServerTemplate(String minigame, String containerId) {
        this.minigame = minigame;
        this.containerId = containerId;
        this.maps = new ArrayList<>();
    }

    public String getContainerId() {
        return containerId;
    }

    public String getMinigame() {
        return minigame;
    }

    public void addMap(String map) {
        this.maps.add(map);
    }

    public List<String> getMaps() {
        return maps;
    }
}
