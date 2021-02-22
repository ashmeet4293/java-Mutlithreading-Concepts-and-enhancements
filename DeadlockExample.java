package com.company.multithreading;
class A{
    synchronized void d1(B b){
        System.out.println("Thread1 starts execution of d1() method ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread1 tyring to call B's last() method ");
        b.last();
    }
    synchronized void last(){
        System.out.println("Inside A, last() method ");
    }
}
class B{
    synchronized void d2(A a){
        System.out.println("Thread2 starts execution of d2() method ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread2 tyring to call A's last() method ");
        a.last();
    }
    synchronized void last(){
        System.out.println("Inside B, last() method ");
    }
}

public class DeadlockExample {


    public static void main(String[] args) {
        A a= new A();
        B b = new B();
        Runnable runnable= ()-> a.d1(b);;
        Runnable runnable1= ()->{b.d2(a);};
        Thread thread= new Thread(runnable);
        Thread thread1= new Thread(runnable1);

       thread.start();
        thread1.start();
    }

}
