package net.thehunter365.spectrolus.dns.requests;

import eu.roboflax.cloudflare.CloudflareAccess;
import eu.roboflax.cloudflare.CloudflareRequest;
import eu.roboflax.cloudflare.CloudflareResponse;
import eu.roboflax.cloudflare.constants.Category;

public class UpdateDnsRecord implements DnsRecordRequest {

    private CloudflareRequest request;


    private Category category;

    private String zoneId;
    private String recordId;

    private String type;
    private String name;
    private String content;
    private int ttl;
    private boolean proxied;


    public UpdateDnsRecord(CloudflareAccess access, Category category) {
        this.category = category;
        this.request = new CloudflareRequest(this.category, access);
    }

    @Override
    public Category getCategory() {
        return this.category;
    }

    public UpdateDnsRecord withIdentifiers(String zoneId, String recordId) {
        this.zoneId = zoneId;
        this.recordId = recordId;

        this.request.identifiers(zoneId, recordId);
        return this;
    }

    public UpdateDnsRecord withType(String type) {
        this.type = type;
        this.request
                .body("type", type);
        return this;
    }

    public UpdateDnsRecord withName(String name) {
        this.name = name;
        this.request
                .body("name", name);
        return this;
    }

    public UpdateDnsRecord withContent(String content) {
        this.content = content;
        this.request
                .body("content", content);
        return this;
    }

    public UpdateDnsRecord withTTL(int ttl) {
        this.ttl = ttl;
        this.request
                .body("ttl", ttl);
        return this;
    }

    public UpdateDnsRecord setProxied(boolean proxied) {
        this.proxied = proxied;
        this.request
                .body("proxied", proxied);
        return this;
    }

    public CloudflareResponse<Void> execute() {
        return this.request.send();
    }

    public CloudflareRequest getRequest() {
        return request;
    }

    public String getZoneId() {
        return zoneId;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getTtl() {
        return ttl;
    }

    public boolean isProxied() {
        return proxied;
    }
}
