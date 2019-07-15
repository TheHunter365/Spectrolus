package net.thehunter365.spectrocloudflare.https;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpsConnection {

    private String url;
    private String query;

    public HttpsConnection(String url, String query) {
        this.url = url;
        this.query = query;
    }

    public String exec(String requestMethod) throws Exception {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(this.url + query);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(requestMethod);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
