package net.thehunter365.spectrolus.utils;

import java.io.*;

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


    public static String loadFile(File file) {
        StringBuilder sb = new StringBuilder();
        if (file.exists()) {
            try {
                String line;
                BufferedReader reader = new BufferedReader(new FileReader(file));

                while ((line = reader.readLine()) != null) sb.append(line);

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void save(File file, String content) {
        
    }
}
