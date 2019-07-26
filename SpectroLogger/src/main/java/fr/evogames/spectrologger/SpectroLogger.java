package fr.evogames.spectrologger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.evogames.spectrologger.log.LogsCleanupTask;
import fr.evogames.spectrologger.log.LogsCollector;
import fr.evogames.spectrologger.log.LogsManager;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SpectroLogger {

    private ScheduledExecutorService scheduler;

    private Gson gson;
    private SpectrolusConnector connector;

    private LogsManager logsManager;
    private LogsCollector logsCollector;

    private LogsCleanupTask logsCleanupTask;

    public SpectroLogger() {

        this.scheduler = Executors.newScheduledThreadPool(2);

        this.gson = new GsonBuilder()
                .serializeNulls()
                .create();

        this.connector = new SpectrolusConnector(this.gson);

        this.logsManager = new LogsManager();
        this.logsCollector = new LogsCollector(this.logsManager);
        this.logsCleanupTask = new LogsCleanupTask(this.logsManager, this.connector);

        this.connector.getEventManager().registerPacketListener(this.logsCollector);

        this.scheduler.scheduleAtFixedRate(
                this.logsCleanupTask,
                0,
                15,
                TimeUnit.MINUTES
        );
    }
}
