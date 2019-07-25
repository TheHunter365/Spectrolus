package net.thehunter365.spectrolus.servermanager.docker.network;

public class DockerNetwork {


    private String networkName;
    private NetworkDriver networkDriver;

    public DockerNetwork(String networkName, NetworkDriver networkDriver) {
        this.networkName = networkName;
        this.networkDriver = networkDriver;
    }

    public NetworkDriver getNetworkDriver() {
        return networkDriver;
    }

    public String getNetworkName() {
        return networkName;
    }
}
