package net.thehunter365.spectrolus.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFile {


    private File file;
    private FileWriter fileWriter;

    LogFile(String name) {
        this.file = new File("./" + name);

        try {
            if (!this.file.exists()) this.file.createNewFile();
            this.fileWriter = new FileWriter(this.file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void writeLine(String line) {
        try {
            this.fileWriter.write(line + "\n");
            this.fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
