package net.thehunter365.spectroworld.storage;

import net.thehunter365.spectroworldapi.shem.AbstractSchematic;

public class Schematic extends AbstractSchematic {

    private int sizeX, sizeY, sizeZ;

    private SchematicBlocks blocks;

    public Schematic(int sizeX, int sizeY, int sizeZ, SchematicBlock[][][] blocks) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.blocks = new SchematicBlocks(blocks);
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    @Override
    public int getSizeZ() {
        return sizeZ;
    }

    @Override
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    @Override
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    @Override
    public void setSizeZ(int sizeZ) {
        this.sizeZ = sizeZ;
    }

    @Override
    public SchematicBlocks getBlocks() {
        return blocks;
    }
}
