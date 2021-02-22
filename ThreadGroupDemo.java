package com.company.multithreading;

public class ThreadGroupDemo {
    public static void main(String[] args) {

//        Runnable runnable=()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println("First Thread : "+i);
//            }
//        };
//        Runnable runnable1=()->{
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Second Thread : "+i);
//            }
//        };
//
//        ThreadGroup threadGroup=new ThreadGroup("Lopping Thread ");
//        Thread thread= new Thread(threadGroup,runnable);
//        Thread thread1= new Thread(threadGroup, runnable1);
//
//        thread.start();
//        thread1.start();
//
//        System.out.println("Thread group name : "+threadGroup.getName());
//        threadGroup.list();

        /** Thread group Priority*/
//        ThreadGroup g1= new ThreadGroup("tg");
//        Thread t1= new Thread(g1, "Thread 1");
//        Thread t2= new Thread(g1, "Thread 2");
//        g1.setMaxPriority(Thread.MIN_PRIORITY);
//        Thread t3= new Thread(g1, "Thread 3");
//        System.out.println(t1.getPriority());
//        System.out.println(t2.getPriority());
//        System.out.println(t3.getPriority());

        /** Program to Display all active thread names belongs to system group and child group */

        ThreadGroup system= Thread.currentThread().getThreadGroup().getParent();
        Thread []threads= new Thread[system.activeCount()];
        system.enumerate(threads);
        for (Thread thread: threads) {
            System.out.println(thread.getName()+" : "+thread.isDaemon());
        }



    }
}
