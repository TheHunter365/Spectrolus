package net.thehunter365.spectroworld.storage;

import fr.evogames.evoworldapi.shem.AbstractBlock;
import fr.evogames.evoworldapi.shem.AbstractBlocks;

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
