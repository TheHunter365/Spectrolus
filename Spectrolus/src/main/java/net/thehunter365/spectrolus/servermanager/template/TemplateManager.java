package net.thehunter365.spectrolus.servermanager.template;

import java.io.File;
import java.util.List;

public class TemplateManager {

    private String templateFolderName;

    private List<ServerTemplate> templates;

    public TemplateManager(String templateFolder) {
        this.templateFolderName = templateFolder;
    }

    public int checkForServers() {
        File[] minigames = this.minigamesFiles();

        if (minigames == null) {
            return 0;
        } else {
            return minigames.length;
        }
    }

    public File[] minigamesFiles() {
        File templateFolder = new File(templateFolderName);
        File[] files = null;
        if (templateFolder.exists()) {

            File minigameFolder = new File(templateFolder, "minigames/");

            if (minigameFolder.exists()) {

                File[] minigames = minigameFolder.listFiles();

                assert minigames != null;
                if (minigames.length != 0) {
                    files = minigames;
                }
            }
        }
        return files;
    }

    public File[] getMaps(File minigameFolder) {
        File[] maps = null;
        File mapsFolder = new File(minigameFolder, "maps/");
        if (mapsFolder.exists()) maps = mapsFolder.listFiles();
        return maps;
    }

    public String getTemplateFolderName() {
        return templateFolderName;
    }
}
