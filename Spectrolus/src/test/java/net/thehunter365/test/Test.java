package net.thehunter365.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(8);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i <= 10; i ++) {
            for (int j = 0; j <= 10; j++) {
                Callable<Integer> worker = worker(i, j);
                Future<Integer> integerFuture = service.submit(worker);
                futures.add(integerFuture);
            }
        }

        System.out.println("blablabla");
        System.out.println("blablabla");
        System.out.println("blablabla");
        System.out.println("blablabla");

        futures.forEach(f-> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });



    }


    public static Callable<Integer> worker(int a, int b) {
        return ()-> a*b;
    }
}
