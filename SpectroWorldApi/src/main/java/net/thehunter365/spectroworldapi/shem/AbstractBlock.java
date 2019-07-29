package net.thehunter365.spectroworldapi.shem;


import java.io.Serializable;

public abstract class AbstractBlock implements Serializable {

    public abstract int getId();
    public abstract byte getData();

}
