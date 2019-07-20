package net.thehunter365.spectrolus.servermanager.docker.swarm;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.*;

import java.util.List;

public class DockerSwarm {


    private DockerClient client;

    public DockerSwarm(DockerClient client) {
        this.client = client;
    }

    public void runService(DockerService service) {
        this.client.createServiceCmd(service.toSwarmService())
                .exec();
    }

    public Swarm getSwarm() {
        return this.client.inspectSwarmCmd().exec();
    }

    public List<Service> listServices() {
        return this.client.listServicesCmd().exec();
    }



}
