package net.thehunter365.spectrolus.servermanager;

import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerService;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerSwarm;
import net.thehunter365.spectrolus.utils.IdGenerator;
import net.thehunter365.spectrolusconnector.protocol.packet.proxy.ProxyHookServerPacket;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GameServerManager {

    private Spectrolus spectrolus;
    private DockerSwarm dockerSwarm;

    private Set<String> gameServer;
    private Set<String> gameProxy;

    private int ports;

    public GameServerManager(Spectrolus spectrolus) {
        this.dockerSwarm = spectrolus.getDockerSwarm();

        this.ports = 45565;
    }

    public DockerSwarm getDockerSwarm() {
        return dockerSwarm;
    }

    public String startProxy() {
        String id = "proxy"+ IdGenerator.getId();

        DockerService service = new DockerService(
                id, "evo-proxy", "evo-net"
        );
        service.setTargetPort(25577);
        service.setPublishedPort(this.ports);
        this.ports++;

        service.setHostname(id);

        this.dockerSwarm.runService(service);
        this.gameProxy.add(id);
        return id;
    }

    public String startServer(String type) {
        String id = type+IdGenerator.getId();

        DockerService service = new DockerService(id, "evo-"+type, "evo-net");
        service.setHostname(id);

        this.dockerSwarm.runService(service);

        this.gameServer.add(id);

        ProxyHookServerPacket packet = new ProxyHookServerPacket(id, 25565);
        this.spectrolus.getSpectrolusConnector()
                .getConnectionManager()
                .sendPacket("SpectroProxy", packet);

        return id;
    }

    public void stopProxy(String id) {

        DockerService service = this.dockerSwarm.getServices()
                .stream().filter(service1 -> service1.getName().equals(id))
                .findFirst()
                .orElse(null);

        this.gameProxy.remove(id);
        if (service != null) {
            this.dockerSwarm.removeService(service);
        }
    }

    public void stopServer(String id) {

        DockerService service = this.dockerSwarm
                .getServices()
                .stream().filter(service1 -> service1.getName().equals(id))
                .findFirst()
                .orElse(null);
        this.gameServer.remove(id);
        if (service != null) {
            this.dockerSwarm.removeService(service);
        }
    }


    public void initGames() {
        this.startProxy();

        String id = this.startServer("hub");
        ProxyHookServerPacket packet = new ProxyHookServerPacket(id, 25565);
        this.spectrolus.getScheduler()
                .schedule(()->
                        this.spectrolus.getSpectrolusConnector().getConnectionManager().sendPacket("evo-proxy", packet),
                        5,
                        TimeUnit.SECONDS
                );
    }


    public Set<String> getGameProxy() {
        return gameProxy;
    }

    public Set<String> getGameServer() {
        return gameServer;
    }
}
