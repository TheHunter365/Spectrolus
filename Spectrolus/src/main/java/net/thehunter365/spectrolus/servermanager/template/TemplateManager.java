package net.thehunter365.spectrolus.servermanager.template;

import java.io.File;

public class TemplateManager {

    private File templateFolder;

    public TemplateManager(String templateFolder) {
        this.templateFolder = new File(templateFolder);
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
        File[] files = null;
        if (this.templateFolder.exists()) {

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

    public File getTemplateFolder() {
        return templateFolder;
    }
}
