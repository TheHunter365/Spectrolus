package net.thehunter365.spectrolus.dns;

import eu.roboflax.cloudflare.CloudflareAccess;
import eu.roboflax.cloudflare.CloudflareResponse;
import net.thehunter365.spectrolus.Spectrolus;
import net.thehunter365.spectrolus.dns.requests.DnsRecordRequest;

public class CloudFlareManager {

    private Spectrolus spectrolus;

    private String apiKey;
    private String email;

    private CloudflareAccess cloudflareAccess;

    public CloudFlareManager(Spectrolus spectrolus, String apiKey, String email) {
        this.apiKey = apiKey;
        this.email = email;

        this.cloudflareAccess = new CloudflareAccess(this.apiKey, this.email, spectrolus.getExecutorService());

    }

    public void shutdown() {
        this.cloudflareAccess.close();
    }

    public CloudflareResponse<Void> executeRequest(DnsRecordRequest recordRequest) {
        return recordRequest.execute();
    }


}
