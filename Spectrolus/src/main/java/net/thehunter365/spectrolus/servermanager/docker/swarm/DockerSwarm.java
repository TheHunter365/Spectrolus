package net.thehunter365.spectrolus.servermanager.docker.swarm;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DockerSwarm {

    private DockerClient client;

    private Set<DockerService> services;

    public DockerSwarm(DockerClient client) {
        this.client = client;
        this.services = new HashSet<>();
    }

    public void runService(DockerService service) {
        this.client.createServiceCmd(service.toSwarmService())
                .exec();
        this.services.add(service);
    }

    public void removeService(DockerService service) {
        this.client.removeServiceCmd(service.getName())
                .exec();
        this.services.remove(service);
    }

    public Swarm getSwarm() {
        return this.client.inspectSwarmCmd().exec();
    }

    public List<Service> listServices() {
        return this.client.listServicesCmd().exec();
    }

    public Set<DockerService> getServices() {
        return services;
    }
}
