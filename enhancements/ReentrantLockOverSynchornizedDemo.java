package com.company.multithreading.enhancements;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockOverSynchornizedDemo {
    static ReentrantLock reentrantLock= new ReentrantLock();

    static void wish(String name ){

        reentrantLock.lock();
        for (int i = 1; i <= 10; i++) {
            System.out.println(name+" wishing for "+i+" times ");
        }
        reentrantLock.unlock();
    }


    public static void main(String[] args) {

        Runnable runnable=()->{
           wish("ashmeet");
        };
        Runnable runnable1=()->{
            wish("Tiwary");
        };

        Thread thread= new Thread(runnable);
        Thread thread1= new Thread(runnable1);

        System.out.println(reentrantLock.getQueueLength());

        thread.start();
        thread1.start();

    }
}
