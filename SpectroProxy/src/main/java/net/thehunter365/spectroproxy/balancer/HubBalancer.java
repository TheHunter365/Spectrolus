package net.thehunter365.spectroproxy.balancer;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;
import net.thehunter365.spectrolusconnector.protocol.event.EventHandler;
import net.thehunter365.spectrolusconnector.protocol.event.PacketListener;
import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;
import net.thehunter365.spectroproxy.SpectroProxy;

import java.util.Set;


public class HubBalancer extends PacketListener implements Listener {

    private String channel;
    private SpectrolusConnector connector;

    public HubBalancer(SpectrolusConnector connector) {
        this.channel = SpectroProxy.CHANNEL;
        this.connector = connector;
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {

    }

    @net.md_5.bungee.event.EventHandler
    public void onJoin(PostLoginEvent event) {
        ProxiedPlayer proxiedPlayer = event.getPlayer();

    }

    @Override
    public String getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(String channel) {
        this.channel = channel;
    }

    private Set<String> getHubs() {
        return this.connector.getConnectionManager().getChannelsByType("hub");
    }
}
