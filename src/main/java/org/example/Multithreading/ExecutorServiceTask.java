package org.example.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTask {

    static void main(String[] args) {

        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            executor.submit(() -> {
                int square = number * number;
                System.out.println(Thread.currentThread().getName() + ": " + number + "^2 = " + square);
            });
        }
        executor.shutdown();
    }
}
