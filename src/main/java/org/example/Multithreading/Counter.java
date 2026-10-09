package org.example.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class  Counter  {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}







