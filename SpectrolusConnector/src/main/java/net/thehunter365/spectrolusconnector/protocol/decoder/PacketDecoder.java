package net.thehunter365.spectrolusconnector.protocol.decoder;

import com.google.gson.Gson;
import net.thehunter365.spectrolusconnector.protocol.Protocol;
import net.thehunter365.spectrolusconnector.protocol.packet.AbstractPacket;

public class PacketDecoder {

    private Gson gson;

    public PacketDecoder(Gson gson) {
        this.gson = gson;
    }


    public AbstractPacket decodePacket(String raw) {
        AbstractPacket packet;

        String[] rawSplited = raw.split(Protocol.SPLIT_CHAR);
        int id = Integer.parseInt(rawSplited[0]);
        String packetJson = rawSplited[1];

        packet = gson.fromJson(packetJson, Protocol.getPacketClass(id));
        return packet;
    }

}
