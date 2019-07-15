package net.thehunter365.spectrolus;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectrolus.console.AsyncCommandExecutor;
import net.thehunter365.spectrolus.console.CommandManager;
import net.thehunter365.spectrolus.log.Logger;
import net.thehunter365.spectrolus.servermanager.GameServerManager;
import net.thehunter365.spectrolus.servermanager.commands.DockerHostCommand;
import net.thehunter365.spectrolus.servermanager.commands.TemplateCommand;
import net.thehunter365.spectrolus.servermanager.docker.DockerClientPool;
import net.thehunter365.spectrolus.servermanager.docker.DockerRemoteManager;
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

    private DockerRemoteManager dockerRemoteManager;
    private DockerClientPool dockerClientPool;
    private GameServerManager gameServerManager;

    private DockerClient localClient;

    public Spectrolus() {
        LOGGER = new Logger();

        this.localClient = DockerClientBuilder.getInstance("tcp://localhost:2375").build();

        this.executorService = Executors.newFixedThreadPool(8);

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        this.spectrolusConnector = new SpectrolusConnector();

        this.commandManager = new CommandManager();
        this.asyncCommandExecutor = new AsyncCommandExecutor(this.commandManager);

        this.executorService.submit(this.asyncCommandExecutor);

        this.dockerRemoteManager = new DockerRemoteManager();
        this.dockerClientPool = new DockerClientPool(this.dockerRemoteManager);

        //this.dockerClientPool.addRemoteHost(new DockerRemote(true, "tcp://144.76.154.85:2375"));

        //this.dockerClientPool.checkHosts();
        this.gameServerManager = new GameServerManager(this.dockerClientPool);

        this.gameServerManager.buildTemplates();

    }


    private void registerCommands() {
        this.commandManager.createCommand("template", new TemplateCommand(this.gameServerManager));
        this.commandManager.createCommand("dockerh", new DockerHostCommand(this.dockerClientPool));
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

    public GameServerManager getGameServerManager() {
        return gameServerManager;
    }

    public DockerClientPool getDockerClientPool() {
        return dockerClientPool;
    }

    public DockerClient getLocalClient() {
        return localClient;
    }
}
