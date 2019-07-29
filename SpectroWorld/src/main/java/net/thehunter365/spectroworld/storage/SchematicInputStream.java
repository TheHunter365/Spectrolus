package net.thehunter365.spectroworld.storage;

import com.github.luben.zstd.Zstd;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SchematicInputStream extends DataInputStream {

    /**
     * Creates a DataInputStream that uses the specified
     * underlying InputStream.
     *
     * @param in the specified input stream
     */
    public SchematicInputStream(InputStream in) {
        super(in);
    }

    public byte[] readCompressed() throws IOException {
        int compressedLength = readInt();

        int uncompressedLength = readInt();

        byte[] compressed = readByteArray(compressedLength);
        byte[] uncompressed = Zstd.decompress(compressed, uncompressedLength);

        if (uncompressed.length != uncompressedLength) throw new IllegalStateException();
        return uncompressed;
    }

    public byte[] readByteArray(int length) throws IOException {
        byte[] array = new byte[length];

        int readByteCount = read(array);
        if (readByteCount == -1) throw new IOException();
        return array;
    }

    public int[] readIntArray(int length) throws IOException {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = readInt();
        }

        return array;
    }
}
