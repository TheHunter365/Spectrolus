package net.thehunter365.spectrolus;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectrolus.config.Config;
import net.thehunter365.spectrolus.config.ConfigManager;
import net.thehunter365.spectrolus.console.AsyncCommandExecutor;
import net.thehunter365.spectrolus.console.CommandManager;
import net.thehunter365.spectrolus.log.Logger;
import net.thehunter365.spectrolus.protocol.SpectroProtocol;
import net.thehunter365.spectrolus.servermanager.GameServerManager;
import net.thehunter365.spectrolus.servermanager.commands.DockerCommand;
import net.thehunter365.spectrolus.servermanager.docker.DockerLogManager;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerSwarm;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Spectrolus {

    private static Logger LOGGER;

    private ExecutorService executorService;
    private ScheduledExecutorService scheduler;


    private Gson gson;

    private Config config;

    private SpectrolusConnector spectrolusConnector;

    private CommandManager commandManager;
    private AsyncCommandExecutor asyncCommandExecutor;

    private DockerClient localClient;

    private DockerSwarm dockerSwarm;

    private GameServerManager gameServerManager;

    private DockerLogManager logManager;

    public Spectrolus() {
        LOGGER = new Logger();

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        this.config = new ConfigManager(this.gson, "./").loadConf();

        this.localClient = DockerClientBuilder.getInstance("unix:///var/run/docker.sock").build();
        this.dockerSwarm = new DockerSwarm(this.localClient);

        this.executorService = Executors.newFixedThreadPool(8);
        this.scheduler = Executors.newScheduledThreadPool(2);


        this.spectrolusConnector = new SpectrolusConnector(this.gson,
                this.config.getRedisConfig().getHostname(),
                this.config.getRedisConfig().getPort()
                );

        this.commandManager = new CommandManager();
        this.asyncCommandExecutor = new AsyncCommandExecutor(this.commandManager);

        this.executorService.submit(this.asyncCommandExecutor);

        this.logManager = new DockerLogManager(this.dockerSwarm, this.spectrolusConnector);
        this.scheduler.scheduleAtFixedRate(this.logManager, 20, 1, TimeUnit.SECONDS);

        this.gameServerManager = new GameServerManager(this);
        this.gameServerManager.initGames();

        this.getSpectrolusConnector().getEventManager()
                .registerListener(new SpectroProtocol(this));

    }


    private void registerCommands() {
        this.commandManager.createCommand("docker", new DockerCommand(this.dockerSwarm));
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public SpectrolusConnector getSpectrolusConnector() {
        return spectrolusConnector;
    }

    public Gson getGson() {
        return gson;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public ScheduledExecutorService getScheduler() {
        return scheduler;
    }

    public DockerClient getLocalClient() {
        return localClient;
    }

    public DockerSwarm getDockerSwarm() {
        return dockerSwarm;
    }

    public GameServerManager getGameServerManager() {
        return gameServerManager;
    }
}
