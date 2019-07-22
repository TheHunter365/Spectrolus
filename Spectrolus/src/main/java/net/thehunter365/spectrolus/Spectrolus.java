package net.thehunter365.spectrolus;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectrolus.console.AsyncCommandExecutor;
import net.thehunter365.spectrolus.console.CommandManager;
import net.thehunter365.spectrolus.log.Logger;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerSwarm;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Spectrolus {

    private static Logger LOGGER;

    private ExecutorService executorService;

    private Gson gson;

    private SpectrolusConnector spectrolusConnector;

    private CommandManager commandManager;
    private AsyncCommandExecutor asyncCommandExecutor;

    //private DockerRemoteManager dockerRemoteManager;
    //private DockerClientPool dockerClientPool;
    //private GameServerManager gameServerManager;

    private DockerClient localClient;

    private DockerSwarm dockerSwarm;

    public Spectrolus() {
        LOGGER = new Logger();

        this.localClient = DockerClientBuilder.getInstance("/var/run/docker.sock").build();
        this.dockerSwarm = new DockerSwarm(this.localClient);

        this.executorService = Executors.newFixedThreadPool(8);

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        this.spectrolusConnector = new SpectrolusConnector(this.gson);

        this.commandManager = new CommandManager();
        this.asyncCommandExecutor = new AsyncCommandExecutor(this.commandManager);

        this.executorService.submit(this.asyncCommandExecutor);


        //this.gameServerManager = new GameServerManager(this.dockerClientPool);

        //this.gameServerManager.buildTemplates();

    }


    private void registerCommands() {
        //this.commandManager.createCommand("template", new TemplateCommand(this.gameServerManager));
        //this.commandManager.createCommand("dockerh", new DockerHostCommand(this.dockerClientPool));
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

    /*public GameServerManager getGameServerManager() {
        return gameServerManager;
    }

    public DockerClientPool getDockerClientPool() {
        return dockerClientPool;
    }*/

    public DockerClient getLocalClient() {
        return localClient;
    }
}
