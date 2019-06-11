package net.thehunter365.spectrolus.servermanager.docker;

public class DockerRemote {


    private boolean enabled;
    private String host;
    private int minPort;
    private int currentPort;
    private int maxPort;


    public DockerRemote(boolean enabled, String host) {
        this.enabled = enabled;
        this.host = host;
        this.minPort = 35565;
        this.currentPort = 35565;
        this.maxPort = 45565;
    }

    public int getNextPort() {
        this.currentPort = currentPort+1;
        return this.currentPort;
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
