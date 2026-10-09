package org.example.Multithreading;

public class Task1 {

    public static void main(String[] args){
        Runnable task = (()-> {for ( int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        try {
        Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        }});

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
