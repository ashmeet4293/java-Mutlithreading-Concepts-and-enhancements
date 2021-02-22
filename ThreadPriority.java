package com.company.multithreading;

public class ThreadPriority {

    public static void main(String[] args) {

        Runnable runnable= ()->{
            for(int i=0; i< 5; i++){
                System.out.println("1st Thread : "+(i+1));
            }
        };

        Runnable runnable1= ()->{
            for(int i=0; i< 5; i++){
                System.out.println("2nd Thread : "+(i+1));
            }
        };

        Thread.currentThread().setPriority(8);
        Thread thread= new Thread(runnable);
        Thread thread1= new Thread(runnable1);
        System.out.println(thread.getPriority());
//        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);

        thread.start();
        thread1.start();

        System.out.println("Main Thread");


    }
}
