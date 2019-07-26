package fr.evogames.spectrologger.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogsManager {

    private File logs;

    private Map<String, FileWriter> writers;

    public LogsManager() {
        this.logs = new File("./logs/");

        this.writers = new HashMap<>();
    }

    private FileWriter getWriter(String fileName) throws IOException {
        FileWriter writer = this.writers.containsKey(fileName) ?
                this.writers.get(fileName) : new FileWriter(new File(this.logs, fileName), true);
        this.writers.remove(fileName);
        this.writers.put(fileName, writer);
        return writer;
    }

    public void writeLog(String name, String line) {
        try {
            FileWriter writer = this.getWriter(name);
            writer.write(line + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, FileWriter> getWriters() {
        return writers;
    }
}
