package org.example.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter {

    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }

    public int getValue(){
        return counter.get();
    }

    static void main(String[] args) throws InterruptedException {
        SimpleCounter simpleCounter = new SimpleCounter();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10; i++){
            executor.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    simpleCounter.increment();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Итого:" + simpleCounter.getValue());
    }


}
