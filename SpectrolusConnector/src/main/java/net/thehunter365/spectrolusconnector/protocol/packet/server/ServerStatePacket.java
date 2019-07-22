package net.thehunter365.spectrolusconnector.protocol.packet.server;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class ServerStatePacket extends AbstractPacket {

    public enum State {
        WAITING,
        RUNNING,
        END;
    }

    private String id;
    private State state;

    public ServerStatePacket(String id, State state) {
        this.id = id;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public State getState() {
        return state;
    }
}
