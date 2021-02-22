package com.company.multithreading;

class Table{
    synchronized void printTable(int valueToPrintTable){
        for(int i=1; i<=5 ;i ++){
            System.out.println(i+ " * "+valueToPrintTable+" = "+(i*valueToPrintTable));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}

public class SynchronizedThread {
    public static void main(String[] args) {

        Table table= new Table();

        Runnable runnable= ()->{table.printTable(5);};
        Runnable runnable1= ()->{table.printTable(10);};

        Thread thread= new Thread(runnable);
        Thread thread1= new Thread(runnable1);

        thread.start();
        thread1.start();

    }
}
