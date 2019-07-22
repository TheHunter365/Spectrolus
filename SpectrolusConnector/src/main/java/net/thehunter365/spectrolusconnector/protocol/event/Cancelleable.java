package net.thehunter365.spectrolusconnector.protocol.event;

public interface Cancelleable {

    void setCancelled(boolean cancelled);
    boolean isCancelled();
}
