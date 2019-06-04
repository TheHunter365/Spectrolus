package net.thehunter365.spectrolus.console;

import net.thehunter365.spectrolus.Spectrolus;

import java.util.Scanner;

public class AsyncCommandExecutor implements Runnable {

    private CommandManager commandManager;

    public AsyncCommandExecutor(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            this.executeCommand(scanner.next());
        }
    }

    private void executeCommand(String raw) {
        String[] firstSplit = raw.split(" ");
        String labelOAlias = firstSplit[0];
        Command command = commandManager.getCommand(labelOAlias);
        String[] args = raw.replace(labelOAlias, "").split(" ");

        if (command != null) {
            command.setArgs(args);
            command.execute();
        } else {
            Spectrolus.getLogger().warn("Unknown command !");
        }
    }
}
