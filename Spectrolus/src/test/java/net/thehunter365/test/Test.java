package net.thehunter365.test;

import net.thehunter365.spectrolus.utils.IdGenerator;

public class Test {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(IdGenerator.getId());
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Executed in: " + time + "ms");
    }
}
