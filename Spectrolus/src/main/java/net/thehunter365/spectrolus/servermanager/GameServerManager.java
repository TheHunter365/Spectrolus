package net.thehunter365.spectrolus.servermanager;

import net.thehunter365.spectrolus.servermanager.docker.DockerClientPool;

public class GameServerManager {

    private DockerClientPool dockerClientPool;

    public GameServerManager() {
        this.dockerClientPool = new DockerClientPool();
    }
}
