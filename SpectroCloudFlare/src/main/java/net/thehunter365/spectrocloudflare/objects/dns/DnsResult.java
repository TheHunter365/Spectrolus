package net.thehunter365.spectrocloudflare.objects.dns;

public class DnsResult {

    private String modifiedOn;
    private String data;
    private String zoneName;
    private String proxied;
    private String type;
    private String ttl;
    private String content;
    private String zoneId;
    private String createdOn;
    private String name;
    private String id;
    private String locked;
    private String proxiable;

    public String getModifiedOn() {
        return modifiedOn;
    }

    public String getData() {
        return data;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getProxied() {
        return proxied;
    }

    public String getType() {
        return type;
    }

    public String getTtl() {
        return ttl;
    }

    public String getContent() {
        return content;
    }

    public String getZoneId() {
        return zoneId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getLocked() {
        return locked;
    }

    public String getProxiable() {
        return proxiable;
    }
}
