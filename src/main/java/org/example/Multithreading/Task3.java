package org.example.Multithreading;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Thread[] thread = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(() -> {
                int result = account.withdraw(150);
                if (result != -1) {
                    System.out.println("Снятие наличных " + "-" + result);
                } else {
                    System.out.println("Недостаточно средств");
                }
            });
            thread[i].start();
        }
        for (int i = 0; i < 10; i++) {
            thread[i].join();
        }

        System.out.println("ИТОГОВЫЙ СЧЕТ:" + account.balance);

    }
}
