package net.thehunter365.spectrolusconnector.protocol.packet.spectrologger;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

import java.util.Set;

public class ServiceDiscoveryPacket extends AbstractPacket {

    private Set<String> services;

    public ServiceDiscoveryPacket(Set<String> services) {
        this.services = services;
    }

    public Set<String> getServices() {
        return services;
    }
}
