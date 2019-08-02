package java.net.thehunter365.spectroworld;

import net.thehunter365.spectroworld.storage.Schematic;
import net.thehunter365.spectroworld.storage.SchematicBlock;
import net.thehunter365.spectroworld.storage.mongo.MongoFs;
import net.thehunter365.spectroworld.storage.compression.zstd.ZstdCompressionManager;

public class Test {


    public static void main(String[] args) {
        MongoFs mongoFs = new MongoFs("mapdata", "mapfiles");

        Schematic schematic = new Schematic(2, 2, 2, new SchematicBlock[][][]{});
        ZstdCompressionManager compressionManager = new ZstdCompressionManager();
        byte[] in = compressionManager.compress(schematic);
        mongoFs.uploadData("map", "Schematic.shem", in);

        byte[] out = mongoFs.downloadData("Schematic.shem");
        Schematic o = compressionManager.decompress(out);
    }
}
