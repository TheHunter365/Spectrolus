package net.thehunter365.spectrocloudflare;

import com.google.gson.Gson;

public class SpectroCloudFlare {


    private Gson gson;
    private String apiKey;

    private String endPoint;

    public SpectroCloudFlare(Gson gson, String apiKey) {
        this.gson = gson;
        this.apiKey = apiKey;
        this.endPoint = "https://api.cloudflare.com/client/v4";
    }
}
