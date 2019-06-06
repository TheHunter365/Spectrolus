package net.thehunter365.spectrolus.servermanager;

import net.thehunter365.spectrolus.servermanager.docker.DockerClientPool;
import net.thehunter365.spectrolus.servermanager.docker.ProxyContainer;
import net.thehunter365.spectrolus.servermanager.docker.ServerContainer;
import net.thehunter365.spectrolus.servermanager.template.TemplateManager;

import java.io.File;
import java.util.List;

public class GameServerManager {

    private DockerClientPool dockerClientPool;

    private TemplateManager templateManager;

    private List<ProxyContainer> proxies;
    private List<ServerContainer> servers;

    public GameServerManager() {
        this.dockerClientPool = new DockerClientPool();
        this.templateManager = new TemplateManager("templates/");
    }

    public void initTemplates() {
        int minigamesCount = templateManager.checkForServers();

        if (minigamesCount == 0) return;
        File[] minigames = this.templateManager.minigamesFiles();

    }

    public DockerClientPool getDockerClientPool() {
        return dockerClientPool;
    }
}
