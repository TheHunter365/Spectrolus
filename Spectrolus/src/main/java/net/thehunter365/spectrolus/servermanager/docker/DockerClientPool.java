package net.thehunter365.spectrolus.servermanager.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;

import java.util.HashMap;
import java.util.Map;

public class DockerClientPool {

    private Map<DockerRemote, DockerClient> dockerClientMap;

    public DockerClientPool() {
        this.dockerClientMap = new HashMap<>();
    }

    public void addRemoteHost(DockerRemote remote) {
        if (remote.isEnabled()) {
            DockerClient dockerClient = DockerClientBuilder.getInstance(remote.getHost()).build();
            this.dockerClientMap.put(remote, dockerClient);
        }
    }

    private Map.Entry<DockerRemote, DockerClient> getRemoteHostEntry(DockerRemote remote) {
        return this.dockerClientMap.entrySet().stream().filter(entry -> entry.getKey().equals(remote)).findFirst().orElse(
                null
        );
    }

    public DockerClient getRemoteHost(DockerRemote remote) {
        Map.Entry<DockerRemote, DockerClient> entry = this.getRemoteHostEntry(remote);
        return entry == null ? null : entry.getValue();
    }


}
