package net.thehunter365.spectrolus.utils;

import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {


    private static final char[] RUNES = "abcdefghijiklmnopqrstuvwxyz123456789".toCharArray();

    public static String randomGeneration(int size) {
        StringBuilder sb = new StringBuilder();
        int lengh = RUNES.length;

        for (int i = 0; i < size; i++) {
            int index = ThreadLocalRandom.current().nextInt(lengh-1);
            sb.append(RUNES[index]);
        }
        return sb.toString();
    }


    public static String getId() {
        return randomGeneration(3);
    }
}
