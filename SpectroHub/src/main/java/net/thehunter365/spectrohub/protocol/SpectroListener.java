package net.thehunter365.spectrohub.protocol;


import net.thehunter365.spectrohub.SpectroHub;
import net.thehunter365.spectrolusconnector.protocol.event.EventHandler;
import net.thehunter365.spectrolusconnector.protocol.event.PacketListener;
import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;

public class SpectroListener extends PacketListener {

    private SpectroHub spectroHub;

    private final String id;

    public SpectroListener(SpectroHub spectroHub) {
        this.spectroHub = spectroHub;
        this.id = spectroHub.getServerId();
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {

    }

    @Override
    public String getChannel() {
        return "hub"+"-"+this.id;
    }

    @Override
    public void setChannel(String channel) {
    }
}
