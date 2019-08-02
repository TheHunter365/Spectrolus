package net.thehunter365.spectroworld.storage.compression;

public interface CompressionManager {

    byte[] compress(Object object);
    Object decompress(byte[] array);

}
