package net.thehunter365.spectrolus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectrolus.console.AsyncCommandExecutor;
import net.thehunter365.spectrolus.console.CommandManager;
import net.thehunter365.spectrolus.log.Logger;
import net.thehunter365.spectrolus.servermanager.GameServerManager;
import net.thehunter365.spectrolus.servermanager.commands.DockerHostCommand;
import net.thehunter365.spectrolus.servermanager.commands.TemplateCommand;
import net.thehunter365.spectrolus.servermanager.docker.DockerClientPool;
import net.thehunter365.spectrolus.servermanager.docker.DockerRemote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Spectrolus {

    private static Logger LOGGER;

    private ExecutorService executorService;

    private Gson gson;

    private CommandManager commandManager;
    private AsyncCommandExecutor asyncCommandExecutor;

    private DockerClientPool dockerClientPool;
    private GameServerManager gameServerManager;

    public Spectrolus() {
        LOGGER = new Logger();

        this.executorService = Executors.newFixedThreadPool(8);

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        this.commandManager = new CommandManager();
        this.asyncCommandExecutor = new AsyncCommandExecutor(this.commandManager);

        this.executorService.submit(this.asyncCommandExecutor);

        this.dockerClientPool = new DockerClientPool();

        this.dockerClientPool.addRemoteHost(new DockerRemote(true, "tcp://144.76.154.85:2375"));

        this.dockerClientPool.checkHosts();
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
}
