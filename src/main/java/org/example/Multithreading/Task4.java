package org.example.Multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Task4 {

    static void main(String[] args) throws InterruptedException {

        AtomicInteger totalSum = new AtomicInteger(0);

        int[] numbers = new int[100];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }
        int expectedSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            expectedSum += numbers[i];
        }
        System.out.println("Ожидаемая сумма (обычный подсчёт): " + expectedSum);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                totalSum.addAndGet(numbers[i]);
                System.out.println("Сумма данного потока" + totalSum.get());
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 50; i++) {
                totalSum.addAndGet(numbers[i]);
                System.out.println("Сумма данного потока" + totalSum.get());
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 50; i < 75; i++) {
                totalSum.addAndGet(numbers[i]);
                System.out.println("Сумма данного потока" + totalSum.get());
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 75; i < 100; i++) {
                totalSum.addAndGet(numbers[i]);
                System.out.println("Сумма данного потока" + totalSum.get());
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();


        System.out.println("Сумма потоков " + totalSum);
    }
}


