package net.thehunter365.spectrolusconnector.protocol.packet.player;

import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

import java.util.UUID;

public class MapReadyPacket extends AbstractPacket {


    private String serverId;
    private UUID worldUniqueId;
    private double x, y, z;
    private float yaw, pitch;

    public MapReadyPacket(String serverId, UUID worldUniqueId, double x, double y, double z, float yaw, float pitch) {
        this.serverId = serverId;
        this.worldUniqueId = worldUniqueId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public String getServerId() {
        return serverId;
    }

    public UUID getWorldUniqueId() {
        return worldUniqueId;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }
}
