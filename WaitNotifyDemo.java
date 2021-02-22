package com.company.multithreading;

class MyThread extends Thread{
    int total=0;
    public void run(){
        synchronized (this){
            for (int i = 1; i <= 100; i++) {
                total = total + i;
            }
//            System.out.println("Main Thread tyring to call wait() method ");
            this.notify();
        }
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread= new MyThread();
        myThread.start();

        synchronized (myThread){
            System.out.println("Main Thread tyring to call wait() method ");
            myThread.wait();
            System.out.println("Main Thread got notification ");
            System.out.println(myThread.total);
        }




    }
}
