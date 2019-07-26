package net.thehunter365.spectrolus.servermanager.docker;

import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.Service;
import com.github.dockerjava.core.command.LogContainerResultCallback;
import net.thehunter365.spectrolus.servermanager.docker.swarm.DockerSwarm;
import net.thehunter365.spectrolusconnector.SpectrolusConnector;
import net.thehunter365.spectrolusconnector.protocol.packet.spectrologger.LogPacket;

import java.util.List;
import java.util.Objects;

public class DockerLogManager implements Runnable {

    private String logChannel;

    private SpectrolusConnector connector;

    private DockerSwarm dockerSwarm;
    private List<Service> services;

    private int current;

    public DockerLogManager(DockerSwarm dockerSwarm, SpectrolusConnector connector) {
        this.logChannel = "SpectroLogger";
        this.current = 0;
        this.connector = connector;
        this.dockerSwarm = dockerSwarm;
        this.services = this.dockerSwarm.listServices();
    }

    public void run() {
        this.current++;

        this.services.stream()
                .filter(service -> service.getSpec() != null && service.getSpec().getName() != null)
                .forEach(service -> {
            String id = service.getId();
            LogContainerResultCallback callback = new LogContainerResultCallback() {
                @Override
                public void onNext(Frame item) {
                    if (item != null) {
                        String log = item.toString();
                        if (!log.equals("")) {
                            sendLogToLogger(id, Objects.requireNonNull(service.getSpec()).getName(), log);
                        }
                    }
                    super.onNext(item);
                }
            };
            this.dockerSwarm.getClient().logServiceCmd(id).exec(callback);
        });

        if (current == 30) {
            this.current = 0;
            this.updateServices();
        }
    }

    private void sendLogToLogger(String id, String name, String line) {
        LogPacket packet = new LogPacket(id, name, line);

        this.connector.getConnectionManager()
                .sendPacket(this.logChannel, packet);
    }

    private void updateServices() {
        this.services = this.dockerSwarm.listServices();
    }
}
