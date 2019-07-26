package net.thehunter365.spectrolus.servermanager.docker.images;

import net.thehunter365.spectrolus.Spectrolus;

public class DockerImageManager {


    private Spectrolus spectrolus;
    private ImageWorker imageWorker;

    public DockerImageManager(Spectrolus spectrolus) {
        this.spectrolus = spectrolus;
        this.imageWorker = new ImageWorker(spectrolus);
    }


}
