package net.thehunter365.spectroworld.storage;

import net.thehunter365.spectroworldapi.shem.loc.AbstractLocation;

import java.util.UUID;

public class SchematicLocation implements AbstractLocation {

    private UUID uuid;
    private int x, y, z;

    float yaw, pitch;

    public SchematicLocation(UUID uuid, int x, int y, int z) {
        this.uuid = uuid;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public UUID getWorldId() {
        return uuid;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }
}
