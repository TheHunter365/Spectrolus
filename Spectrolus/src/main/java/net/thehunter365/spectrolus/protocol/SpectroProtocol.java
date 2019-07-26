package net.thehunter365.spectrolus.protocol;

import com.github.dockerjava.api.model.Service;
import com.github.dockerjava.api.model.ServiceSpec;
import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolusconnector.protocol.event.EventHandler;
import net.thehunter365.spectrolusconnector.protocol.event.Listener;
import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.AskForServiceDiscoveryPacket;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.ServiceDiscoveryPacket;

import java.util.Set;
import java.util.stream.Collectors;


public class SpectroProtocol implements Listener {

    private Spectrolus spectrolus;

    public SpectroProtocol(Spectrolus spectrolus) {
        this.spectrolus = spectrolus;
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {
        AbstractPacket packet = event.getPacket();

        if (packet instanceof AskForServiceDiscoveryPacket) {
            this.discoveryProtocol(packet);
        }
    }

    private void discoveryProtocol(AbstractPacket abstractPacket) {
        AskForServiceDiscoveryPacket packet = (AskForServiceDiscoveryPacket) abstractPacket;
        String channel = packet.getChannel();

        Set<String> services = this.spectrolus.getDockerSwarm()
                .listServices()
                .parallelStream()
                .filter(service -> service.getSpec() != null && service.getSpec().getName() != null)
                .map(Service::getSpec)
                .map(ServiceSpec::getName)
                .collect(Collectors.toSet());
        ServiceDiscoveryPacket serviceDiscoveryPacket = new ServiceDiscoveryPacket(services);
        this.spectrolus.getSpectrolusConnector()
                .getConnectionManager().sendPacket(channel, serviceDiscoveryPacket);
    }
}
