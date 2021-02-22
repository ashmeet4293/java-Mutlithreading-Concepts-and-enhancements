package com.company.multithreading.enhancements;

import java.util.concurrent.*;

/** Unlike Runnable interface Callable interface returns some result after the execution of Thread
 * It has only one method i.e. public Object call() */
class MyCallable implements Callable{
    int number;
    public MyCallable(int number){
        this.number=number;
    }

    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 1; i <= number; i++) {
            sum=sum+i;
        }
        return sum;
    }
}

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable callables[]={
                new MyCallable(10),
                new MyCallable(20),
                new MyCallable(30),
                new MyCallable(40),
                new MyCallable(50)

        };

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        for (Callable callable: callables) {
            /*Future object helps to store the value return from the call() method of Callable interface */
            Future callableResult = executorService.submit(callable);
            System.out.println(callableResult.get());
        }
        executorService.shutdown();
    }
}
