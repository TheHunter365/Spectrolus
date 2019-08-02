package net.thehunter365.spectroworld.storage;


import net.thehunter365.spectroworldapi.shem.AbstractBlock;
import org.bukkit.block.Block;

import java.io.Serializable;

public class SchematicBlock extends AbstractBlock implements Serializable {

    private String material;
    private byte data;

    public SchematicBlock(Block block) {
        this.material = block.getType().name();
        this.data = block.getData();
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public byte getData() {
        return data;
    }

}
