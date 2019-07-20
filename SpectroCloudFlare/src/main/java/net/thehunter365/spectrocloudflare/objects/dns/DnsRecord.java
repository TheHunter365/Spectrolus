package net.thehunter365.spectrocloudflare.objects.dns;

public class DnsRecord {

    private DnsResult[] dnsResults;
    private String success;
    private String[] messages;
    private String[] errors;

    public DnsResult[] getDnsResults() {
        return dnsResults;
    }

    public String getSuccess() {
        return success;
    }

    public String[] getMessages() {
        return messages;
    }

    public String[] getErrors() {
        return errors;
    }
}
