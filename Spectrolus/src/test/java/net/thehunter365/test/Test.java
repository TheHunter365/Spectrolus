package net.thehunter365.test;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Network;
import com.github.dockerjava.api.model.Service;
import com.github.dockerjava.api.model.ServiceSpec;
import com.github.dockerjava.core.DockerClientBuilder;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        /*DockerClient client = DockerClientBuilder.getInstance("tcp://localhost:2375").build();

        List<Image> images = client.listImagesCmd().exec();

        ServiceSpec serviceSpec = new ServiceSpec();

        images.forEach(image -> System.out.println("Name: " + image.getRepoTags()[0]+ " Size: " + image.getSize()));


        List<Network> networkList = client.listNetworksCmd().exec();
        networkList.forEach(network -> System.out.println(
                "Driver: " + network.getDriver() + " Name: " + network.getName()
        ));*/

    }
}