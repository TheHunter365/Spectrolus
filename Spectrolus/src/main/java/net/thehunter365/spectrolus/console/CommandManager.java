package net.thehunter365.spectrolus.console;

import net.thehunter365.spectrolus.Spectrolus;

import java.util.HashSet;
import java.util.Set;

public class CommandManager {

    private Set<Command> commands;

    public CommandManager() {
        this.commands = new HashSet<>();
    }

    private void registerCommand(Command command) {
        Spectrolus.getLogger().info("Registered: " + command.getLabel() + " command!");
        this.commands.add(command);
    }

    public Command getCommand(String label) {
        return this.commands.stream().filter(command -> command.getLabel().equals(label)).findFirst().orElse(null);
    }

    public void createCommand(String label, CommandExecutor executor) {
        Command command = new Command(label);
        command.setExecutor(executor);
        this.registerCommand(command);
    }
}
