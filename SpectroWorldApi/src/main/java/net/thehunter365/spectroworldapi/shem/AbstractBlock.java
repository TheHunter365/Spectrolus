package net.thehunter365.spectroworldapi.shem;


import java.io.Serializable;

public abstract class AbstractBlock implements Serializable {

    public abstract String getMaterial();
    public abstract byte getData();

}
