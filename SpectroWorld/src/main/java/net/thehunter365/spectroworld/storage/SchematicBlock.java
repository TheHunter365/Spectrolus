package net.thehunter365.spectroworld.storage;


import fr.evogames.evoworldapi.shem.AbstractBlock;
import org.bukkit.material.MaterialData;

import java.io.Serializable;

public class SchematicBlock extends AbstractBlock implements Serializable {

    private int x, y, z;
    private int id;
    private byte data;

    public SchematicBlock(int x, int y, int z, MaterialData materialData) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.id = materialData.getItemTypeId();
        this.data = materialData.getData();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public byte getData() {
        return data;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
