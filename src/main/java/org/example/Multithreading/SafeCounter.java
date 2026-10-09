package org.example.Multithreading;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SafeCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet(); // атомарно +1
    }

    public int getValue() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        SafeCounter safeCounter = new SafeCounter();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    safeCounter.increment();
                }
            });
        }

        executor.shutdown(); // больше задачи не принимаем
        executor.awaitTermination(1, TimeUnit.MINUTES); // ждем завершения

        System.out.println("Итог: " + safeCounter.getValue()); // Должно быть 5000
    }
}


