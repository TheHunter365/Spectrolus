package net.thehunter365.spectroworld.storage;


import net.thehunter365.spectroworldapi.shem.AbstractBlock;
import net.thehunter365.spectroworldapi.shem.AbstractBlocks;

public class SchematicBlocks extends AbstractBlocks {


    private SchematicBlock[][][] blocks;

    public SchematicBlocks(SchematicBlock[][][] blocks) {
        this.blocks = blocks;
    }
    @Override
    public AbstractBlock[][][] getBlocksArray() {
        return new AbstractBlock[0][][];
    }
}
