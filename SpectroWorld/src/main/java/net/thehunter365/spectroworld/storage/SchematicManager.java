package net.thehunter365.spectroworld.storage;


import net.thehunter365.spectroworld.SpectroWorld;
import net.thehunter365.spectroworld.storage.compression.CompressionManager;
import net.thehunter365.spectroworld.storage.mongo.MongoFs;
import net.thehunter365.spectroworldapi.shem.AbstractSchematic;

public class SchematicManager implements net.thehunter365.spectroworldapi.shem.SchematicManager {

    private MongoFs mongoFs;
    private SchematicLoader schematicLoader;
    private CompressionManager compressionManager;

    public SchematicManager(SpectroWorld spectroWorld) {
        this.mongoFs = spectroWorld.getMongoFs();
        this.schematicLoader = new SchematicLoader();
        this.compressionManager = spectroWorld.getCompressionManager();
    }

    public SchematicLoader getSchematicLoader() {
        return schematicLoader;
    }

    @Override
    public void saveSchematic(String type, String name, AbstractSchematic schematic) {

        byte[] array = this.compressionManager.compress(schematic);
        this.mongoFs.uploadData(type, name, array);
    }

    @Override
    public AbstractSchematic loadSchematic(String name) {
        byte[] array = this.mongoFs.downloadData(name);
        return (AbstractSchematic) this.compressionManager.decompress(array);
    }


}
