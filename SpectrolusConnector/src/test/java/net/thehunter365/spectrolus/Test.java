package net.thehunter365.spectrolus;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(8);

        JedisPoolConfig config = new JedisPoolConfig();
        JedisPool pool = new JedisPool(config);

        Jedis jedis = pool.getResource();

        int operation;
        System.out.println("Enter operation number: ");
        Scanner scanner = new Scanner(System.in);

        operation = Integer.parseInt(scanner.next());

        long start = System.currentTimeMillis();

        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i <= operation; i++) {
            pipeline.set("test"+i, "value"+i);
            pipeline.get("test"+i);
        }
        pipeline.sync();

        long end = System.currentTimeMillis() - start;
        System.out.println("Took: " + end +"ms");
        scanner.close();

    }
}
