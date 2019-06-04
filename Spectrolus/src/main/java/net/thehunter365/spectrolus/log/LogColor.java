package net.thehunter365.spectrolus.log;

public enum LogColor {

    BLACK("\\u001B[30m"),
    RED("\\u001B[31m"),
    GREEN("\\u001B[32m"),
    YELLOW("\\u001B[32m"),
    BLUE("\\u001B[34m"),
    PURPLE("\\u001B[35m"),
    CYAN("\\u001B[36m");

    private String code;

    LogColor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
