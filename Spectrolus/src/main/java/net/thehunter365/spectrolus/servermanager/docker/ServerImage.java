package net.thehunter365.spectrolus.servermanager.docker;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.utils.IdGenerator;

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

    public ServerContainer toContainer(DockerRemote remote, DockerClient client) {

        String name = this.minigame+this.map+"-"+ IdGenerator.getId();
        int port = remote.getNextPort();

        ServerContainer container = new ServerContainer(remote.getHost(), name, this.map, this.minigame, port);
        ExposedPort tcp25565 = ExposedPort.tcp(25565);

        HostConfig hostConfig = new HostConfig()
                .withPortBindings(new PortBinding(Ports.Binding.bindPort(port), tcp25565));

        CreateContainerResponse containerResponse = client.createContainerCmd(containerTag)
                .withHostConfig(hostConfig)
                .exec();
        container.setId(containerResponse.getId());
        Spectrolus.getLogger().success("Successfully created: " + name + " container !");

        client.startContainerCmd(containerResponse.getId()).exec();
        Spectrolus.getLogger().success("Successfully started: " + name + " container !");

        return container;
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
