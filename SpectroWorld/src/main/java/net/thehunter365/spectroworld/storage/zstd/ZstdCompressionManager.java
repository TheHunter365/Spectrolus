package net.thehunter365.spectroworld.storage.zstd;

import com.github.luben.zstd.Zstd;
import net.thehunter365.spectroworld.storage.Schematic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ZstdCompressionManager {

    public ZstdCompressionManager() {
    }


    public byte[] compress(Object object) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(object);

            return Zstd.compress(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Schematic decompress(byte[] bytes, int size) {

        byte[] decompressed = Zstd.decompress(bytes, size);
        return null;
    }

}
