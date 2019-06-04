package net.thehunter365.spectrolus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectrolus.console.AsyncCommandExecutor;
import net.thehunter365.spectrolus.console.CommandManager;
import net.thehunter365.spectrolus.log.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Spectrolus {

    private static Logger LOGGER;

    private ExecutorService executorService;

    private Gson gson;

    private CommandManager commandManager;
    private AsyncCommandExecutor asyncCommandExecutor;

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
}
