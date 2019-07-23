package fr.evogames.spectrologger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;

public class SpectroLogger {

    private Gson gson;
    private SpectrolusConnector connector;

    public SpectroLogger() {

        this.gson = new GsonBuilder()
                .serializeNulls()
                .create();

        this.connector = new SpectrolusConnector(this.gson);
    }
}
