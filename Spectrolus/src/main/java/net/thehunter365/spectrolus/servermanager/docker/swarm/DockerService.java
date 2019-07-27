package net.thehunter365.spectrolus.servermanager.docker.swarm;

import com.github.dockerjava.api.model.*;

import java.util.*;

public class DockerService {

    private String name;

    private String imageId;
    private String network;

    private String hostname;

    private Map<String, String> mount;
    private Map<Integer, Integer> portMap;

    private int publishedPort;
    private int targetPort;

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

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getHostname() {
        return hostname;
    }

    public void setPublishedPort(int publishedPort) {
        this.publishedPort = publishedPort;
    }

    public void setTargetPort(int targetPort) {
        this.targetPort = targetPort;
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

        EndpointSpec endpointSpec = new EndpointSpec()
                .withMode(EndpointResolutionMode.VIP)
                .withPorts(Arrays.asList(
                        new PortConfig()
                        .withProtocol(PortConfigProtocol.TCP)
                        .withPublishedPort(this.publishedPort)
                        .withTargetPort(this.targetPort)
                ));

        TaskSpec taskSpec = new TaskSpec()
                .withContainerSpec(containerSpec)
                .withNetworks(networks);
        ServiceSpec serviceSpec = new ServiceSpec();
        serviceSpec.withName(this.name)
                .withTaskTemplate(taskSpec)
                .withEndpointSpec(endpointSpec);

        return serviceSpec;
    }
}
