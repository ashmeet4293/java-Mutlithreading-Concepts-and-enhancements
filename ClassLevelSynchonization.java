package com.company.multithreading;

class Display{
    public synchronized void displayNumber(){
        for (int i = 1; i <=10 ; i++) {
            System.out.print(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized  void displayCharacter(){
        for (int i = 65; i <=90 ; i++) {
            System.out.print((char)i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ClassLevelSynchonization {
    public static void main(String[] args) {

        Display display= new Display();

        Runnable runnable= ()->{display.displayNumber();};
        Runnable runnable1= ()->{display.displayCharacter();};

        Thread thread= new Thread(runnable);
        Thread thread1= new Thread(runnable1);

        thread.start();
        thread1.start();

    }
}
