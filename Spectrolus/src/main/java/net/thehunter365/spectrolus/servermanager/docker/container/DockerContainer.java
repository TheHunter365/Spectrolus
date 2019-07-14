package net.thehunter365.spectrolus.servermanager.docker.container;

import java.util.HashMap;
import java.util.Map;

public class DockerContainer {

    private String name;
    private String id;

    private String imageName;
    private String imageId;

    private Map<Integer, Integer> portMap;
    private Map<String, String> volumeMap;

    public DockerContainer(String name, String id, String imageName, String imageId) {
        this.name = name;
        this.id = id;
        this.imageName = imageName;
        this.imageId = imageId;

        this.portMap = new HashMap<>();
        this.volumeMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageId() {
        return imageId;
    }

    public Map<Integer, Integer> getPortMap() {
        return portMap;
    }

    public Map<String, String> getVolumeMap() {
        return volumeMap;
    }

    public void addPort(int hPort, int cPort) {
        this.portMap.put(hPort, cPort);
    }

    public void addVolume(String hPath, String cPath) {
        this.volumeMap.put(hPath, cPath);
    }
}
