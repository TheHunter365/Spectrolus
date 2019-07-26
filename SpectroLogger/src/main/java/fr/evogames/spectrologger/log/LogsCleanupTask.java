package fr.evogames.spectrologger.log;

import net.thehunter365.spectrolusconnector.SpectrolusConnector;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.LogPacket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogsCleanupTask implements Runnable {

    private LogsManager manager;
    private SpectrolusConnector connector;

    public LogsCleanupTask(LogsManager manager, SpectrolusConnector connector) {
        this.manager = manager;
        this.connector = connector;
    }

    @Override
    public void run() {
        LogPacket logPacket = new LogPacket("SpectroLogger", "SpectroLogger",
                this.log("Successfully Cleared Writers"));
        this.manager.getWriters()
                .clear();
        this.connector.getConnectionManager().sendPacket("SpectroLogger", logPacket);
    }

    private String log(String message) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return "[" + format.format(calendar) + "] - " + message;
    }
}
