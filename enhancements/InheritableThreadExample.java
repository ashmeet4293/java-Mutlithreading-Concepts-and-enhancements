package com.company.multithreading.enhancements;

class ParentThread extends Thread{
    public static InheritableThreadLocal inheritableThreadLocal= new InheritableThreadLocal(){
        /* Setting up the child value */
        public Object childValue(Object p){
            return "Child Value 1";
        }
    };
    public void run(){
        inheritableThreadLocal.set("Parent value 1");
        System.out.println("Parent Thread : "+inheritableThreadLocal.get());
        /*Starting the child Thread runs under parent Thread */
        new ChildThread().start();

    }
}
class ChildThread extends Thread{
    @Override
    public void run() {
        /*Accessing the child value using inhertiable thread local of parent Thread*/
        System.out.println("Child Thread Value : "+ParentThread.inheritableThreadLocal.get());
    }
}

public class InheritableThreadExample {
    public static void main(String[] args) {
        ParentThread parentThread= new ParentThread();
        parentThread.start();
    }
}
