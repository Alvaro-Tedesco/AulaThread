package com.example.demo;

public class Test {

    public void run(){
        Runnable r = () -> {
            System.out.println("Thread em execução: " + Thread.currentThread().getName());
            for (int i = 0; i < 8; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r, "Thread 1");
        Thread t2 = new Thread(r, "Thread 2");

        t1.start();
        t2.start();
    }
}
