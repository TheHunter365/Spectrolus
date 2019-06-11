package net.thehunter365.spectrolus.servermanager.commands;

import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.console.CommandExecutor;
import net.thehunter365.spectrolus.servermanager.GameServerManager;

public class TemplateCommand implements CommandExecutor {

    private GameServerManager gameServerManager;

    public TemplateCommand(GameServerManager gameServerManager) {
        this.gameServerManager = gameServerManager;
    }

    @Override
    public void executeCommand(String[] args) {
        int length = args.length;
        if (length == 1) {
            switch (args[0]) {
                case "list":
                    this.gameServerManager.getTemplateServers().forEach(
                            template -> {
                                Spectrolus.getLogger().info("Name: " + template.getMinigame());
                                template.getMaps().forEach(map ->  Spectrolus.getLogger().info("Map: " + map));
                            });
                    break;
            }
        }
    }
}
