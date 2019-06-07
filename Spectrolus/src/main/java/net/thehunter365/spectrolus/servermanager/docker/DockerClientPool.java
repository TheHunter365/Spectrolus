package net.thehunter365.spectrolus.servermanager.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.BuildResponseItem;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.BuildImageResultCallback;
import net.thehunter365.spectrolus.Spectrolus;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public void forEachClient(DockerInterface dockerInterface) {
        this.dockerClientMap.forEach((remote, client)-> dockerInterface.forEach(client));
    }

    public void checkHosts() {
        this.dockerClientMap.forEach((host, client) -> {
            Info info = client.infoCmd().exec();
            if (info != null) {
                Spectrolus.getLogger().info("Docker: " + host.getHost() + " is UP !");
            } else {
                Spectrolus.getLogger().warn("Docker: " + host.getHost() + " is DONW !");
            }
        });
    }

    public String buildContainer(DockerClient client, String name, File dockerFile) {
        Set<String> tags = new HashSet<>();
        tags.add(name);
        Spectrolus.getLogger().info("Start Building container " + name);
        BuildImageResultCallback callback = new BuildImageResultCallback() {
            @Override
            public void onNext(BuildResponseItem item) {
                Spectrolus.getLogger().info(item.getStream());
                super.onNext(item);
            }
        };

        return client.buildImageCmd(dockerFile).withTags(tags).exec(callback).awaitImageId();
    }

    public interface DockerInterface {
        void forEach(DockerClient client);
    }
}
