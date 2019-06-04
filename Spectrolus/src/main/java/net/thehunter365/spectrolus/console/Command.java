package net.thehunter365.spectrolus.console;

public class Command {

    private String label;
    private String[] args;

    private CommandExecutor executor;

    public Command(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    public void execute() {
        this.executor.executeCommand(this.args);
    }
}
