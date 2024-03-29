package net.thehunter365.spectroworldapi.shem;

import java.io.Serializable;

public abstract class AbstractSchematic implements Serializable {


    public abstract int getSizeX();
    public abstract int getSizeY();
    public abstract int getSizeZ();

    public abstract void setSizeX(int sizeX);
    public abstract void setSizeY(int sizeY);
    public abstract void setSizeZ(int sizeZ);

    public abstract AbstractBlocks getBlocks();
}
