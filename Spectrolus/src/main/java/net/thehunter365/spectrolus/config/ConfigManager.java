package net.thehunter365.spectrolus.config;

import com.google.gson.Gson;
import net.thehunter365.spectrolus.utils.FileUtils;

import java.io.File;

public class ConfigManager {

    private Gson gson;
    private File confFile;
    private Config config;

    public ConfigManager(Gson gson, String path) {
        this.gson = gson;
        this.confFile = new File("./"+path);
    }

    private Config loadConf(File file) {
        Config config;

        String json = FileUtils.loadFile(file);
        if (!json.equals("")) {
            config = this.gson.fromJson(json, Config.class);
        } else {
            config = new Config();
        }

        return config;
    }
}
