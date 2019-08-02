package net.thehunter365.spectroworld.storage.compression.zstd;

import com.github.luben.zstd.Zstd;
import com.github.luben.zstd.ZstdDirectBufferDecompressingStream;
import net.thehunter365.spectroworld.storage.Schematic;
import net.thehunter365.spectroworld.storage.compression.CompressionManager;
import net.thehunter365.spectroworld.utils.ByteBufferInputStream;

import java.io.*;
import java.nio.ByteBuffer;

public class ZstdCompressionManager implements CompressionManager {

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

    public Schematic decompress(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length * 5);
        ZstdDirectBufferDecompressingStream stream = new ZstdDirectBufferDecompressingStream(
                ByteBuffer.wrap(bytes)
        );
        try {
            stream.read(buffer);
            stream.close();
            ObjectInputStream ois = new ObjectInputStream(new ByteBufferInputStream(buffer));
            return (Schematic) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
