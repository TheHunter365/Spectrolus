package net.thehunter365.spectrolus.servermanager.docker;

import com.github.dockerjava.api.model.Service;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerSwarm;

import java.util.List;

public class DockerLogManager implements Runnable {

    private DockerSwarm dockerSwarm;
    private List<Service> services;

    private int current;

    public DockerLogManager(DockerSwarm dockerSwarm) {
        this.current = 0;
        this.dockerSwarm = dockerSwarm;
        this.services = this.dockerSwarm.listServices();
    }

    public void run() {
        this.current++;

        this.services.forEach(service -> {
        });

        if (current == 30) {
            this.current = 0;
            this.updateServices();
        }
    }


    private void updateServices() {
        this.services = this.dockerSwarm.listServices();
    }
}
