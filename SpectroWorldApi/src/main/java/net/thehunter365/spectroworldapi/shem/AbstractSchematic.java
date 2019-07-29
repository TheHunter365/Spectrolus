package net.thehunter365.spectroworldapi.shem;

import fr.evogames.evoworldapi.zstd.ZstdSerializable;

import java.io.Serializable;

public abstract class AbstractSchematic implements Serializable, ZstdSerializable {


    public abstract int getSizeX();
    public abstract int getSizeY();
    public abstract int getSizeZ();

    public abstract AbstractBlocks getBlocks();
}
