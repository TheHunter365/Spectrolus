package net.thehunter365.spectrolus.servermanager.commands;

import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.console.CommandExecutor;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerSwarm;

import java.util.Objects;

public class DockerCommand implements CommandExecutor {

    private DockerSwarm dockerSwarm;

    public DockerCommand(DockerSwarm dockerSwarm) {
        this.dockerSwarm = dockerSwarm;
    }

    @Override
    public void executeCommand(String[] args) {
        if (args.length > 0) {
            String param = args[0];
            Spectrolus.getLogger().info("");

            switch (param) {
                case "services":
                    Spectrolus.getLogger().info("--------Services-------------");
                    this.dockerSwarm.listServices()
                            .forEach(service -> {
                                Spectrolus.getLogger().info("Name: " + service.getSpec().getName() + " id: " + service.getId() + " image: " + Objects.requireNonNull(service.getSpec().getTaskTemplate()).getContainerSpec().getImage());
                            });
                    break;
                case "ls":
                    Spectrolus.getLogger().info("------------Nodes-------------");
                    break;
                case "":
                    break;
            }
        }

    }
}
