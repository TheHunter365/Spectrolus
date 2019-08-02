package net.thehunter365.spectroworld;

import net.thehunter365.spectroworld.storage.SchematicManager;
import net.thehunter365.spectroworld.storage.compression.CompressionManager;
import net.thehunter365.spectroworld.storage.compression.gzip.GzipCompressionManager;
import net.thehunter365.spectroworld.storage.mongo.MongoFs;
import net.thehunter365.spectroworldapi.SpectroWorldApi;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class SpectroWorld extends JavaPlugin implements SpectroWorldApi {

    private CompressionManager compressionManager;
    private MongoFs mongoFs;
    private SchematicManager schematicManager;

    @Override
    public void onEnable() {

        this.getServer().getServicesManager()
                .register(
                        SpectroWorldApi.class,
                        this,
                        this,
                        ServicePriority.Highest
                );

        this.compressionManager = new GzipCompressionManager();
        this.mongoFs = new MongoFs("", "");

        this.schematicManager = new SchematicManager(this);
    }

    @Override
    public void onDisable() {

    }

    public CompressionManager getCompressionManager() {
        return compressionManager;
    }

    public MongoFs getMongoFs() {
        return mongoFs;
    }

    public SchematicManager getSchematicManager() {
        return schematicManager;
    }
}
