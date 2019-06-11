package net.thehunter365.spectrolus.servermanager.docker;


public class ServerImage {

    private String imageId;
    private String containerTag;

    private String minigame;
    private String map;

    public ServerImage(String imageId, String containerTag, String minigame, String map) {
        this.imageId = imageId;
        this.containerTag = containerTag;
        this.minigame = minigame;
        this.map = map;
    }

    public String getImageId() {
        return imageId;
    }

    public String getContainerTag() {
        return containerTag;
    }

    public String getMinigame() {
        return minigame;
    }

    public String getMap() {
        return map;
    }
}
