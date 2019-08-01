package net.thehunter365.spectroworld.storage.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.Document;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MongoFs {

    private String databaseName;
    private String bucketName;

    private MongoClient client;
    private MongoDatabase database;
    private GridFSBucket bucket;

    public MongoFs(String databaseName, String bucketName) {
        this.databaseName = databaseName;
        this.bucketName = bucketName;
        this.client = MongoClients.create();

        this.initDb();
    }

    private void initDb() {
        this.database = this.client.getDatabase(this.databaseName);
        this.bucket = GridFSBuckets.create(this.database, this.bucketName);
    }

    public void uploadData(String type, String name, byte[] stream) {
        GridFSUploadOptions options = new GridFSUploadOptions()
                .chunkSizeBytes(512000)
                .metadata(new Document("type", type));
        this.bucket.uploadFromStream(name, new ByteArrayInputStream(stream), options);
    }

    public byte[] downloadData(String name) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        this.bucket.downloadToStream(name, os);
        return os.toByteArray();
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public GridFSBucket getBucket() {
        return bucket;
    }


}
