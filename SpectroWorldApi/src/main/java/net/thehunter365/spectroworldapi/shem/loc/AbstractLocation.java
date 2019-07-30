package net.thehunter365.spectroworldapi.shem.loc;

import java.util.UUID;

public interface AbstractLocation {

    UUID getWorldId();
     double getX();
     double getY();
     double getZ();

     float getYaw();
     float getPitch();
}
