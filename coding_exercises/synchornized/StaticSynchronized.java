package com.company.multithreading.coding_exercises.synchornized;

class PrintTable{
    synchronized  static void printTable(int multiplyNumber){
        for (int i = 1; i <= 10; i++) {
            System.out.println(multiplyNumber+" * "+i+" = "+(i*multiplyNumber));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("_______________________________________________");
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        PrintTable.printTable(1);
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        PrintTable.printTable(2);
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        PrintTable.printTable(3);
    }
}
class MyThread3 extends Thread{
    @Override
    public void run() {
        PrintTable.printTable(5);
    }
}

public class StaticSynchronized {
    public static void main(String[] args) {
        MyThread myThread= new MyThread();
        MyThread1 myThread1= new MyThread1();
        MyThread2 myThread2= new MyThread2();
        MyThread3 myThread3= new MyThread3();

        myThread.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();




    }
}
