package com.company.multithreading.enhancements;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJobs implements Runnable{
    String name;
    PrintJobs(String name){
        this.name=name;
    }
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(name +" Job started by Thread : "+threadName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name +" JOB completed by "+threadName);
    }
}

public class ThreadPoolsExample {
    public static void main(String[] args) {

        PrintJobs [] jobs= {
                new PrintJobs("Ashmeet"),
                        new PrintJobs("Tiwary"),
                        new PrintJobs("pawan"),
                        new PrintJobs("raju"),
                        new PrintJobs("naveen")
        };

        ExecutorService executorService= Executors.newFixedThreadPool(3);
        for(PrintJobs job : jobs){
            executorService.submit(job);
        }
        executorService.shutdown();


    }
}
