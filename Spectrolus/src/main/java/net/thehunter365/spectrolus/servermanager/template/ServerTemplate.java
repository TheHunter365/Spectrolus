package net.thehunter365.spectrolus.servermanager.template;

import java.util.ArrayList;
import java.util.List;

public class ServerTemplate {

    private String minigame;
    private String imageId;

    private List<String> maps;

    public ServerTemplate(String minigame, String imageId) {
        this.minigame = minigame;
        this.imageId = imageId;
        this.maps = new ArrayList<>();
    }

    public String getImageId() {
        return imageId;
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
