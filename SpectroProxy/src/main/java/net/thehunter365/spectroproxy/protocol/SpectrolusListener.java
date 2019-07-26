package net.thehunter365.spectroproxy.protocol;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.thehunter365.spectrolusconnector.protocol.event.EventHandler;
import net.thehunter365.spectrolusconnector.protocol.event.Listener;
import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyAlertMessagePacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyHookServerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyRemoveServerPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyRoutePlayerPacket;

import java.net.InetSocketAddress;
import java.util.UUID;

public class SpectrolusListener implements Listener {


    @EventHandler
    public void onPacket(PacketReceiveEvent event) {
        if (event.getChannel().equals("evo-proxy")) {
            AbstractPacket packet = event.getPacket();

            if (packet instanceof ProxyAlertMessagePacket) {

                ProxyAlertMessagePacket proxyAlertMessagePacket = (ProxyAlertMessagePacket) packet;
                this.alert(proxyAlertMessagePacket);

            } else if (packet instanceof ProxyHookServerPacket) {

                ProxyHookServerPacket hookServerPacket = (ProxyHookServerPacket) packet;
                this.proxyHookServer(hookServerPacket);

            } else if (packet instanceof ProxyRemoveServerPacket) {

                ProxyRemoveServerPacket proxyRemoveServerPacket = (ProxyRemoveServerPacket) packet;
                this.proxyRemoveServer(proxyRemoveServerPacket);

            } else if (packet instanceof ProxyRoutePlayerPacket) {

                ProxyRoutePlayerPacket proxyRoutePlayerPacket = (ProxyRoutePlayerPacket) packet;
                this.routePlayer(proxyRoutePlayerPacket);

            }
        }
    }

    private void routePlayer(ProxyRoutePlayerPacket proxyRoutePlayerPacket) {
        String serverId = proxyRoutePlayerPacket.getServerId();
        UUID uuid = proxyRoutePlayerPacket.getPlayerUuid();

        ProxiedPlayer player = ProxyServer.getInstance()
                .getPlayers().stream().filter(proxiedPlayer -> proxiedPlayer.getUniqueId().equals(uuid))
                .findFirst()
                .orElse(null);

        ServerInfo serverInfo = ProxyServer.getInstance()
                .getServers()
                .values().stream()
                .filter(server -> server.getName().equals(serverId))
                .findFirst()
                .orElse(null);

        if (player != null && serverInfo != null) {
            player.connect(serverInfo);
        }
    }

    private void alert(ProxyAlertMessagePacket packet) {
        String message = packet.getMessage();
        ProxyServer.getInstance().broadcast(
                new TextComponent(ChatColor.DARK_RED + "[Spectrolus]- " + message)
        );
    }

    private void proxyHookServer(ProxyHookServerPacket packet) {
        String serverHost = packet.getName();
        int port = packet.getPort();

        ProxyServer.getInstance().constructServerInfo(
                serverHost,
                InetSocketAddress.createUnresolved(serverHost,  port),
                "Another server",
                false
        );
    }

    private void proxyRemoveServer(ProxyRemoveServerPacket packet) {
        ProxyServer.getInstance()
                .getServers().remove(packet.getServerId());

    }
}
