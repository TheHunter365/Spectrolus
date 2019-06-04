package net.thehunter365.spectrolus.servermanager.docker;

public class DockerRemote {


    private boolean enabled;
    private String host;


    public DockerRemote(boolean enabled, String host) {
        this.enabled = enabled;
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
