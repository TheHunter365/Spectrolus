package net.thehunter365.spectrohub.protocol;


        import net.thehunter365.spectrohub.SpectroHub;
        import net.thehunter365.spectrolusconnector.protocol.event.EventHandler;
        import net.thehunter365.spectrolusconnector.protocol.event.Listener;
        import net.thehunter365.spectrolusconnector.protocol.packet.PacketReceiveEvent;

public class SpectroListener implements Listener {

    private SpectroHub spectroHub;

    private final String id;

    public SpectroListener(SpectroHub spectroHub) {
        this.spectroHub = spectroHub;
        this.id = spectroHub.getServerId();
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {

    }

}
