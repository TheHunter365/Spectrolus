package net.thehunter365.spectroworldapi.shem;


import net.thehunter365.spectroworldapi.shem.loc.AbstractLocation;

public interface SchematicManager {

    AbstractSchematic getSchematic(AbstractLocation firstPoint, AbstractLocation secondPoint);

    void loadSchematic(AbstractLocation location, AbstractSchematic schematic);

}
