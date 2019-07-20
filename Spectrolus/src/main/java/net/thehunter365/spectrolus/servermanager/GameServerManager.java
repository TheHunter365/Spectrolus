package net.thehunter365.spectrolus.servermanager;

import com.github.dockerjava.api.DockerClient;
import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.servermanager.docker.DockerClientPool;
import net.thehunter365.spectrolus.servermanager.template.ServerTemplate;
import net.thehunter365.spectrolus.servermanager.template.TemplateManager;
import net.thehunter365.spectrolus.utils.FileUtils;

import java.io.File;
import java.util.*;

public class GameServerManager {

    private DockerClientPool dockerClientPool;

    private TemplateManager templateManager;

    private Set<ServerTemplate> templateServers;


    public GameServerManager(DockerClientPool dockerClientPool) {
        this.dockerClientPool = dockerClientPool;
        this.templateManager = new TemplateManager("templates/");

        this.templateServers = new HashSet<>();

    }

    public void buildTemplates(DockerClient dockerClient) {
        int minigamesCount = templateManager.checkForServers();

        if (minigamesCount == 0) return;
        File[] minigames = this.templateManager.minigamesFiles();

        for (File minigame : minigames) {
            File mapsFolder = new File(minigame, "maps/");
            File[] maps = mapsFolder.listFiles();
            if (maps != null && maps.length != 0) {
                if (FileUtils.exist(minigame, "Dockerfile")) {
                    //String id = this.dockerClientPool.buildContainer(dockerClient, minigame.getName(), new File(minigame, "Dockerfile"));

                    //ServerTemplate template = new ServerTemplate(minigame.getName().replace("/",""), id);
                    //for (File map : maps)template.addMap(map.getName().replace("/", ""));

                    //this.templateServers.add(template);
                    Spectrolus.getLogger().info("Successfully added " + minigame.getName());
                } else {
                    Spectrolus.getLogger().fail("Unknown Dockerfile for " + minigame.getName());
                }
            } else {
                Spectrolus.getLogger().fail("Unknown maps for " + minigame.getName());
            }
        }
    }

    public void buildTemplates() {
        //this.dockerClientPool.forEachClient(this::buildTemplates);
    }

    public Set<ServerTemplate> getTemplateServers() {
        return templateServers;
    }
}
