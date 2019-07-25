package net.thehunter365.spectrohub;

import com.google.gson.Gson;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;
import net.thehunter365.spectrolusconnector.protocol.packet.HeartBeatPacket;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpectroHub extends JavaPlugin {

    private String serverId;
    private Gson gson;
    private SpectrolusConnector spectrolusConnector;

    public void onEnable() {

        try {
            this.serverId = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        this.spectrolusConnector = new SpectrolusConnector(this.gson);


        this.spectrolusConnector.getConnectionManager()
                .sendPacket(new HeartBeatPacket(this.serverId));
    }

    public void onDisable() {

    }

    public String getServerId() {
        return serverId;
    }
}
