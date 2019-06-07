package net.thehunter365.spectrolus.utils;

import java.io.File;

public class FileUtils {

    public static boolean exist(File folder, String name) {
        boolean exist = false;
        File[] list = folder.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.getName().equals(name)) {
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }
}
