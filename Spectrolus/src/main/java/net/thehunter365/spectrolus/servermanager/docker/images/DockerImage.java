package net.thehunter365.spectrolus.servermanager.docker.images;

public class DockerImage {

    private String name;
    private String id;

    public DockerImage(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
