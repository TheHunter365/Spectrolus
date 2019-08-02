package net.thehunter365.spectroworld.storage.compression.gzip;

import net.thehunter365.spectroworld.storage.Schematic;
import net.thehunter365.spectroworld.storage.compression.CompressionManager;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressionManager implements CompressionManager {


    public byte[] compress(Object schematic) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gos = new GZIPOutputStream(bos);
            ObjectOutputStream os = new ObjectOutputStream(gos);
            os.writeObject(schematic);
            gos.close();
            os.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    public Object decompress(byte[] input) {
        ByteArrayInputStream bis = new ByteArrayInputStream(input);
        Schematic schematic = null;
        try {
            GZIPInputStream gis = new GZIPInputStream(bis);
            ObjectInputStream ois = new ObjectInputStream(gis);
            schematic = (Schematic)ois.readObject();
            ois.close();
            gis.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schematic;
    }
}
