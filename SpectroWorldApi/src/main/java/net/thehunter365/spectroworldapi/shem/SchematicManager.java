package net.thehunter365.spectroworldapi.shem;


public interface SchematicManager {

    void saveSchematic(String name, AbstractSchematic schematic);

    AbstractSchematic loadSchematic(String name);

}
