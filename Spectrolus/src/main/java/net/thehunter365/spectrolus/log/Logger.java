package net.thehunter365.spectrolus.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    private LogFile logFile;

    public Logger() {
        this.logFile = new LogFile("Spectrolus.log");
    }

    public void log(String message, LogType logType) {
        String line = logType.getColor() + "["+this.timeNow()+"]" + " [" + logType.getName()+ "]- " + message;
        this.logFile.writeLine(line);
        System.out.println(line);
    }

    public void info(String message) {
        this.log(message, LogType.INFO);
    }

    public void warn(String message) {
        this.log(message, LogType.WARN);
    }

    public void fail(String message) {
        this.log(message, LogType.FAIL);
    }

    public void success(String message) {
        this.log(message, LogType.SUCCESS);
    }

    private String timeNow() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    }
}
