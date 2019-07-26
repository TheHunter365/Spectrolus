package net.thehunter365.spectroproxy.balancer;

import net.thehunter365.spectrolusconnector.protocol.event.EventHandler;
import net.thehunter365.spectrolusconnector.protocol.event.PacketListener;
import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;
import net.thehunter365.spectroproxy.SpectroProxy;

public class HubBalancer extends PacketListener {

    private String channel;

    public HubBalancer() {
        this.channel = SpectroProxy.CHANNEL;
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {

    }

    @Override
    public String getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(String channel) {
        this.channel = channel;
    }
}
