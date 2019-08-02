package net.thehunter365.spectroproxy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectroproxy.protocol.SpectrolusListener;
import net.md_5.bungee.api.plugin.Plugin;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;

public class SpectroProxy extends Plugin {

    public static final String CHANNEL = "SpectroProxy";

    private Gson gson;
    private SpectrolusConnector connector;

    public void onEnable() {
        this.gson = new GsonBuilder()
                .serializeNulls().create();

        this.connector = new SpectrolusConnector(this.gson, "redis", 6379);

        this.connector.getConnectionManager().addChannel(CHANNEL, "");

        this.connector.startPacketHandler();
        this.connector.getEventManager()
                .registerPacketListener(new SpectrolusListener());
    }

    public void onDisable() {

    }

    public Gson getGson() {
        return gson;
    }

    public SpectrolusConnector getConnector() {
        return connector;
    }
}
