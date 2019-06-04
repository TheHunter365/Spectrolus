package net.thehunter365.spectrolus.templatemanager;

public class ServerTemplate {

    private String game;
    private String map;

    public ServerTemplate(String game, String map) {
        this.game = game;
        this.map = map;
    }

    public String getGame() {
        return game;
    }

    public String getMap() {
        return map;
    }
}
