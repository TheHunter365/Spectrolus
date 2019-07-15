package net.thehunter365.spectrolus.servermanager.docker.images;

import com.github.dockerjava.api.model.BuildResponseItem;
import com.github.dockerjava.core.command.BuildImageResultCallback;
import net.thehunter365.spectrolus.Spectrolus;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImageWorker {


    private Spectrolus spectrolus;

    public ImageWorker(Spectrolus spectrolus) {
        this.spectrolus = spectrolus;
    }

    private boolean buildImage(File dockerFile, String tag) {

        BuildImageResultCallback callback = new BuildImageResultCallback() {
            @Override
            public void onNext(BuildResponseItem item) {
                if (item != null)
                    Spectrolus.getLogger().info(item.getStream());
                super.onNext(item);
            }
        };

        String id = this.spectrolus.getLocalClient().buildImageCmd(dockerFile)
                .withTags(Stream.of(tag).collect(Collectors.toSet())).exec(callback).awaitImageId();

        DockerImage image = new DockerImage(tag, id);


        return false;
    }
}
