package com.company.multithreading.enhancements;

class CustomerThread extends Thread{
    static Integer customerId=0;
    private static ThreadLocal tl = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return ++customerId;
        }
    };
    CustomerThread(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+" Executing ... with customer id  "+ tl.get());
    }
}

public class ThreadLocalExample {
    public static void main(String[] args) {

        CustomerThread customerThread1= new CustomerThread("Thread 1");
        CustomerThread customerThread2= new CustomerThread("Thread 2");
        CustomerThread customerThread3= new CustomerThread("Thread 3");
        CustomerThread customerThread4= new CustomerThread("Thread 4");

        customerThread1.start();
        customerThread2.start();
        customerThread3.start();
        customerThread4.start();

    }
}
