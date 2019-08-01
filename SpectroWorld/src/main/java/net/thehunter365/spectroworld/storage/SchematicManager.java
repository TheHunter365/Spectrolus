package net.thehunter365.spectroworld.storage;


import net.thehunter365.spectroworld.storage.mongo.MongoFs;
import net.thehunter365.spectroworldapi.shem.AbstractSchematic;

public class SchematicManager implements net.thehunter365.spectroworldapi.shem.SchematicManager {

    private MongoFs mongoFs;
    private SchematicLoader schematicLoader;

    public SchematicManager(MongoFs mongoFs, SchematicLoader schematicLoader) {
        this.mongoFs = mongoFs;
        this.schematicLoader = schematicLoader;
    }

    @Override
    public void saveSchematic(String name, AbstractSchematic schematic) {

    }

    @Override
    public AbstractSchematic loadSchematic(String name) {
        return null;
    }


}
