package net.thehunter365.spectrolusconnector.protocol.event;


public abstract class PacketListener implements Listener {

    public abstract String getChannel();

    public abstract void setChannel(String channel);


}
