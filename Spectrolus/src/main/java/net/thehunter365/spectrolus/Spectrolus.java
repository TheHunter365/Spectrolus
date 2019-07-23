package net.thehunter365.spectrolus;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectrolus.console.AsyncCommandExecutor;
import net.thehunter365.spectrolus.console.CommandManager;
import net.thehunter365.spectrolus.log.Logger;
import net.thehunter365.spectrolus.servermanager.GameServerManager;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerSwarm;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Spectrolus {

    private static Logger LOGGER;

    private ExecutorService executorService;
    private ScheduledExecutorService scheduler;


    private Gson gson;

    private SpectrolusConnector spectrolusConnector;

    private CommandManager commandManager;
    private AsyncCommandExecutor asyncCommandExecutor;

    private DockerClient localClient;

    private DockerSwarm dockerSwarm;

    private GameServerManager gameServerManager;

    public Spectrolus() {
        LOGGER = new Logger();

        this.localClient = DockerClientBuilder.getInstance("unix:///var/run/docker.sock").build();
        this.dockerSwarm = new DockerSwarm(this.localClient);

        this.executorService = Executors.newFixedThreadPool(8);
        this.scheduler = Executors.newScheduledThreadPool(2);

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        this.spectrolusConnector = new SpectrolusConnector(this.gson);

        this.commandManager = new CommandManager();
        this.asyncCommandExecutor = new AsyncCommandExecutor(this.commandManager);

        this.executorService.submit(this.asyncCommandExecutor);

        this.gameServerManager = new GameServerManager(this);
        this.gameServerManager.initGames();
    }


    private void registerCommands() {
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
