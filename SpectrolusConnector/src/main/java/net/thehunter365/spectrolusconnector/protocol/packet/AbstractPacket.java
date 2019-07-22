package net.thehunter365.spectrolusconnector.protocol.packet;

public abstract class AbstractPacket {

    interface CallBack {

        void acknowledgement();

    }
    public void register(CallBack callBack) {
        callBack.acknowledgement();
    }
}
