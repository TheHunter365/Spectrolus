package net.thehunter365.spectrolus.config;

import com.google.gson.Gson;
import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.utils.FileUtils;

import java.io.File;

public class ConfigManager {

    private Gson gson;
    private File confFile;

    public ConfigManager(Gson gson, String path) {
        this.gson = gson;
        this.confFile = new File("./"+path);
    }

    public Config loadConf() {
        Config config;

        String json = FileUtils.loadFile(this.confFile);
        if (!json.equals("")) {
            config = this.gson.fromJson(json, Config.class);
        } else {
            config = new Config();
            FileUtils.save(this.confFile, this.gson.toJson(config));
            Spectrolus.getLogger().fail("Please fill config file to continue !");
            System.exit(1);
        }

        return config;
    }


}
