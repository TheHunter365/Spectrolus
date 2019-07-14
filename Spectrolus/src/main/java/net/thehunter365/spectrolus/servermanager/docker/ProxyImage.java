package net.thehunter365.spectrolus.servermanager.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.utils.IdGenerator;

public class ProxyImage {

    private String imageId;
    private String imageTag;

    public ProxyImage(String imageId, String imageTag) {
        this.imageId = imageId;
        this.imageTag = imageTag;
    }

    public ProxyContainer toContainer(DockerClient client, String remote, int port) {
        String name = "bungee-"+ IdGenerator.getId();

        ProxyContainer proxyContainer = new ProxyContainer(remote, name, port);

        ExposedPort tcp25577 = ExposedPort.tcp(25577);
        HostConfig hostConfig = new HostConfig()
                .withPortBindings(new PortBinding(Ports.Binding.bindPort(port), tcp25577));

        CreateContainerResponse response = client.createContainerCmd(this.imageTag)
                .withHostConfig(hostConfig).exec();
        String id = response.getId();
        proxyContainer.setId(id);
        Spectrolus.getLogger().success("Successfully created: " + name + " container !");

        client.startContainerCmd(id).exec();

        return proxyContainer;
    }

    public String getImageId() {
        return imageId;
    }

    public String getImageTag() {
        return imageTag;
    }
}
