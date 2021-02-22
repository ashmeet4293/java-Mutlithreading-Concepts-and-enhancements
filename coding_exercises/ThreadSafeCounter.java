package com.company.multithreading.coding_exercises;

public class ThreadSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };

        Thread thread= new Thread(runnable);
        Thread thread1= new Thread(runnable);
        Thread thread2= new Thread(runnable);

        thread.start();
        thread.join();
        thread1.start();
        thread2.start();


    }
}
