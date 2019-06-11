package net.thehunter365.spectrolus.servermanager.commands;

import net.thehunter365.spectrolus.console.CommandExecutor;
import net.thehunter365.spectrolus.servermanager.docker.DockerClientPool;
import net.thehunter365.spectrolus.servermanager.docker.DockerRemote;

public class DockerHostCommand implements CommandExecutor {

    private DockerClientPool dockerClientPool;

    public DockerHostCommand(DockerClientPool dockerClientPool) {
        this.dockerClientPool = dockerClientPool;
    }

    @Override
    public void executeCommand(String[] args) {
        if (args.length == 2) {
            String type = args[0];
            String data = args[1];

            switch (type) {
                case "add":
                    DockerRemote r = new DockerRemote(true, data);

                    break;
                case "remove":

                    break;
                    default:break;
            }
        }
    }
}
