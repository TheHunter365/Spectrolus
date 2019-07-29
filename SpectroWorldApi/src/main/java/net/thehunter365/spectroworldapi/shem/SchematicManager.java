package net.thehunter365.spectroworldapi.shem;

import fr.evogames.evoworldapi.shem.loc.AbstractLocation;

public interface SchematicManager {

    AbstractSchematic getSchematic(AbstractLocation firstPoint, AbstractLocation secondPoint);

    void loadSchematic(AbstractLocation location, AbstractSchematic schematic);

}
