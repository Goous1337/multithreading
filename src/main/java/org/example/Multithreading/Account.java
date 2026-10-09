package org.example.Multithreading;

public class Account {

    int balance = 1000;

    public synchronized int withdraw(int amount) {
        if (balance < amount) {
            return -1;
        } else {
            balance -= amount;
            return balance;
        }
    }
}
