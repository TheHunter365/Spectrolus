package net.thehunter365.spectrolus.servermanager.docker.images;

public class DockerImage {

    private String name;
    private String tag;

    private long sizeByte;

    public DockerImage(String name, String tag, long sizeByte) {
        this.name = name;
        this.tag = tag;
        this.sizeByte = sizeByte;
    }


    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public long getSizeByte() {
        return sizeByte;
    }
}
