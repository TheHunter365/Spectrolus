package net.thehunter365.spectroworldapi.shem;

import net.thehunter365.spectroworldapi.shem.loc.AbstractLocation;

public interface SchematicLoader {

    AbstractSchematic createSchematic(AbstractLocation loc1, AbstractLocation loc2);

    void printSchematic(AbstractLocation location, AbstractSchematic schematic);
}
