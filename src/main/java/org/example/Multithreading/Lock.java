package org.example.Multithreading;

public class Lock {

    public static void main(String[] args){

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread A = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток A захватил lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток A пытается захватить lock2");
                synchronized (lock2) {
                    System.out.println("Поток A захватил lock2");
                }
            }
        });
        A.start();

        Thread B = new Thread(() -> {
            synchronized (lock2){
                System.out.println("Поток Б хаъватил lock2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток Б пытаеться захватить lock1");
            synchronized (lock1){
                System.out.println("Поток Б захватил lock1");
            }
        }
        });
        B.start();
    }
}
