package com.company.multithreading.enhancements;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryLockExample {
    public static void main(String[] args) {
        ReentrantLock reentrantLock= new ReentrantLock();

//        Runnable runnable=()->{
//           if(reentrantLock.tryLock()){
//                   System.out.println(Thread.currentThread().getName()+" got lock and performing safe operation for : ");
//               try {
//                   Thread.sleep(5000);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               reentrantLock.unlock();
//           }else{
//               System.out.println(Thread.currentThread().getName()+" is locked by other thread so unable to get lock" +
//                       "hence performing alternative operations");
//           }
//        };
//
//        Thread thread= new Thread(runnable);
//        Thread thread1= new Thread(runnable);
//        thread.start();
//        thread1.start();


        Runnable runnable1=()->{
            do{
                try {
                    if(reentrantLock.tryLock(5000, TimeUnit.MILLISECONDS)){
                        System.out.println(Thread.currentThread().getName()+" Got Lock ");
                        Thread.sleep(30000);
                        reentrantLock.unlock();
                        System.out.println(Thread.currentThread().getName()+" Releases the lock.. Performing safe operations :) ");
                        break;
                    }else{
                        System.out.println(Thread.currentThread().getName()+ " unable to get lock and will try again ! ");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }while (true);
        };

        Thread thread= new Thread(runnable1);
        Thread thread1= new Thread(runnable1);
        thread.start();
        thread1.start();

    }
}
