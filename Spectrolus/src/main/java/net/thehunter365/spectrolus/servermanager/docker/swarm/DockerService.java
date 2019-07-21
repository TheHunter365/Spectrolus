package net.thehunter365.spectrolus.servermanager.docker.swarm;

import com.github.dockerjava.api.model.ContainerSpec;
import com.github.dockerjava.api.model.NetworkAttachmentConfig;
import com.github.dockerjava.api.model.ServiceSpec;
import com.github.dockerjava.api.model.TaskSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DockerService {

    private String name;

    private String imageId;
    private String network;

    private String hostname;

    private Map<String, String> mount;
    private Map<Integer, Integer> portMap;

    public DockerService(String name, String imageId, String network) {
        this.name = name;
        this.imageId = imageId;
        this.network = network;
        this.mount = new HashMap<>();
        this.portMap = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public String getImageId() {
        return imageId;
    }

    public String getNetwork() {
        return network;
    }

    public void addMount(String local, String container) {
        this.mount.put(local, container);
    }

    public void removeMount(String local, String container) {
        this.mount.remove(local, container);
    }

    public void addPort(int local, int container) {
        this.portMap.put(local, container);
    }

    public void removePort(int local, int container) {
        this.portMap.remove(local, container);
    }

    public Map<String, String> getMount() {
        return mount;
    }

    public Map<Integer, Integer> getPortMap() {
        return portMap;
    }

    public ServiceSpec toSwarmService() {

        ContainerSpec containerSpec = new ContainerSpec()
                .withImage(this.imageId)
                .withHostname(this.hostname);
        List<NetworkAttachmentConfig> networks = new ArrayList<>();
        networks.add(
                new NetworkAttachmentConfig()
                .withTarget(this.network)
        );
        TaskSpec taskSpec = new TaskSpec()
                .withContainerSpec(containerSpec)
                .withNetworks(networks);
        ServiceSpec serviceSpec = new ServiceSpec();
        serviceSpec.withName(this.name)
                .withTaskTemplate(taskSpec);

        return serviceSpec;
    }
}
