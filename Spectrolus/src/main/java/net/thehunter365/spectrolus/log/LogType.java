package net.thehunter365.spectrolus.log;

public enum LogType {

    INFO("Info", LogColor.CYAN),
    SUCCESS("Success", LogColor.GREEN),
    FAIL("Fail", LogColor.RED),
    WARN("Warn", LogColor.RED);

    private String name;
    private LogColor color;

    LogType(String name, LogColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public LogColor getColor() {
        return color;
    }
}
