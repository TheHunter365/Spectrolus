package net.thehunter365.spectroworld.storage;

import java.io.IOException;
import java.io.InputStream;

public class SchematicReader {


    public static Schematic read(InputStream is) {

        try (SchematicInputStream in = new SchematicInputStream(is)) {

            int sizeX = in.readInt();
            int sizeY = in.readInt();
            int sizeZ = in.readInt();



        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
