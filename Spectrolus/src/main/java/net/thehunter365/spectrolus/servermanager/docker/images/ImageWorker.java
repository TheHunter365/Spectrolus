package net.thehunter365.spectrolus.servermanager.docker.images;

import com.github.dockerjava.api.model.BuildResponseItem;
import com.github.dockerjava.api.model.Identifier;
import com.github.dockerjava.api.model.Repository;
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

    public void buildAll() {
        File file = new File("./templates/");
        File[] files = file.listFiles();
        assert files != null;
        Stream.of(files)
                .forEach(f -> this.buildImage(new File(f, "Dockerfile"), f.getName()));
    }

    private boolean buildImage(File dockerFile, String tag) {

        BuildImageResultCallback callback = new BuildImageResultCallback() {
            @Override
            public void onNext(BuildResponseItem item) {
                if (item != null)
                    Spectrolus.getLogger().info(tag + " : " + item.getStream());
                super.onNext(item);
            }
        };

        String id = this.spectrolus.getLocalClient().buildImageCmd(dockerFile)
                .withTags(Stream.of(tag).collect(Collectors.toSet())).exec(callback).awaitImageId();

        DockerImage image = new DockerImage(tag, id);
        Repository repository = new Repository("evogames.fr");
        this.spectrolus.getLocalClient().pushImageCmd(new Identifier(repository, tag));

        return true;
    }
}
