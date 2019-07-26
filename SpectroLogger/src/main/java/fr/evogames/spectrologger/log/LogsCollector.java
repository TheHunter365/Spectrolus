package fr.evogames.spectrologger.log;

import net.thehunter365.spectrolusconnector.protocol.event.EventHandler;
import net.thehunter365.spectrolusconnector.protocol.event.PacketListener;
import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.LogPacket;

public class LogsCollector extends PacketListener {

    private String channel;
    private LogsManager logsManager;

    public LogsCollector(LogsManager logsManager) {
        this.logsManager = logsManager;

        this.channel = "SpectroLogger";
    }

    private void logPacketCollect(AbstractPacket abstractPacket) {
        if (abstractPacket instanceof LogPacket) {
            LogPacket packet = (LogPacket) abstractPacket;

            String name = packet.getName();
            String logLine = packet.getLogLine();

            this.logsManager.writeLog(name, logLine);
        }
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {
        this.logPacketCollect(event.getPacket());
    }

    @Override
    public String getChannel() {
        return channel;
    }

    @Override
    public void setChannel(String channel) {
        this.channel = channel;
    }

    public LogsManager getLogsManager() {
        return logsManager;
    }
}
