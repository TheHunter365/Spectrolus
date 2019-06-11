package net.thehunter365.spectrolus.servermanager.docker;

import net.thehunter365.spectrolus.utils.IdGenerator;

public class ProxyImage {

    private String imageId;
    private String imageTag;

    public ProxyImage(String imageId, String imageTag) {
        this.imageId = imageId;
        this.imageTag = imageTag;
    }
}
