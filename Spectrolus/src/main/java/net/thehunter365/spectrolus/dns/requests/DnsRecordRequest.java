package net.thehunter365.spectrolus.dns.requests;

import eu.roboflax.cloudflare.CloudflareResponse;
import eu.roboflax.cloudflare.constants.Category;

public interface DnsRecordRequest {

    Category getCategory();

    CloudflareResponse<Void> execute();
}
