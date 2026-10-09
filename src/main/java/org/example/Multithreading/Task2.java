package org.example.Multithreading;

public class Task2 {

        public static void main(String[] args) throws InterruptedException {
            Counter counter = new Counter();
            Thread[] threads = new Thread[1000];

            for (int i = 0; i < 1000; i++) {
                threads[i] = new Thread(() -> {
                    counter.increment();
                });
                threads[i].start();
            }
            for (int i = 0; i < 1000; i++) {
                threads[i].join();
            }

            System.out.println("Итоговый счёт: " + counter.count);
        }
}
