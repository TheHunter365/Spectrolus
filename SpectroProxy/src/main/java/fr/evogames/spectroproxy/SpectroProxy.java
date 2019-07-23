package fr.evogames.spectroproxy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.evogames.spectroproxy.protocol.SpectrolusListener;
import net.md_5.bungee.api.plugin.Plugin;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;

public class SpectroProxy extends Plugin {

    private Gson gson;
    private SpectrolusConnector connector;

    public void onEnable() {
        this.gson = new GsonBuilder()
                .serializeNulls().create();

        this.connector = new SpectrolusConnector(this.gson);

        this.connector.getEventManager()
                .registerListener(new SpectrolusListener());
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
