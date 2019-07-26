package net.thehunter365.spectrolus.config.neested;

public class RegistryConfig {

    private String host;
    private String user;
    private String pass;

    public RegistryConfig(String host, String user, String pass) {
        this.host = host;
        this.user = user;
        this.pass = pass;
    }


    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
