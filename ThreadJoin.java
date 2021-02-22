package com.company.multithreading;

public class ThreadJoin {
    public static void main(String[] args) {

        Runnable runnable= ()->{
          for(int i=0;i<5;i++){
//              try {
//                  Thread.sleep(5);
//              } catch (InterruptedException e) {
//                  e.printStackTrace();
//              }
              System.out.println("Thread : "+i);
          }
        };

        Thread thread=new Thread(runnable);
        Thread thread1=new Thread(()->{for(int i=0; i<2;i++){
            System.out.println("Thread 1 "+(i));
        }});
        Thread thread2= new Thread(()->{for(int i=0; i<2;i++){
            System.out.println("Thread 2 "+(i));
        }});

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        thread2.start();


    }
}
