package net.thehunter365.spectrolus.servermanager.docker;

import java.util.HashSet;
import java.util.Set;

public class ImagesManager {

    private Set<ServerImage> serverImages;
    private Set<ProxyImage> proxyImages;

    public ImagesManager() {
        this.serverImages = new HashSet<>();
        this.proxyImages = new HashSet<>();
    }

    public void addServerImage(ServerImage serverImage) {
        this.serverImages.add(serverImage);
    }

    public void removeServerImage(ServerImage serverImage) {
        this.serverImages.remove(serverImage);
    }

    public void addProxyImage(ProxyImage proxyImage) {
        this.proxyImages.add(proxyImage);
    }

    public void removeProxyImage(ProxyImage proxyImage) {
        this.proxyImages.remove(proxyImage);
    }

    public Set<ProxyImage> getProxyImages() {
        return proxyImages;
    }

    public Set<ServerImage> getServerImages() {
        return serverImages;
    }
}
