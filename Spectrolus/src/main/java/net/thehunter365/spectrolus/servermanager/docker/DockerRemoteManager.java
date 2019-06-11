package net.thehunter365.spectrolus.servermanager.docker;

import java.util.ArrayList;
import java.util.List;

public class DockerRemoteManager {


    private List<DockerRemote> remoteList;

    public DockerRemoteManager() {
        this.remoteList = new ArrayList<>();
    }

    public List<DockerRemote> getRemoteList() {
        return remoteList;
    }

    public void addRemote(DockerRemote remote) {
        this.remoteList.add(remote);
    }

    public void removeRemote(DockerRemote remote) {
        this.remoteList.remove(remote);
    }

    public void removeRemote(int index) {
        this.remoteList.remove(index);
    }


}
