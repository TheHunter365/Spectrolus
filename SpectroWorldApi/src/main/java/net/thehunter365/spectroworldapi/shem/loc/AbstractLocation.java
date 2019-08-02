package net.thehunter365.spectroworldapi.shem.loc;

import java.util.UUID;

public interface AbstractLocation {

    UUID getWorldId();
     int getX();
     int getY();
     int getZ();

     float getYaw();
     float getPitch();

}
