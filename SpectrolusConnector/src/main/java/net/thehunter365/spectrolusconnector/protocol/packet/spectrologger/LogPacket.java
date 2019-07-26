package net.thehunter365.spectrolusconnector.protocol.packet.spectrologger;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class LogPacket extends AbstractPacket {

    private String id;
    private String name;
    private String logLine;

    public LogPacket(String id, String name, String logLine) {
        this.id = id;
        this.name = name;
        this.logLine = logLine;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogLine() {
        return logLine;
    }
}
