package com.company.multithreading.enhancements;

import java.util.concurrent.locks.ReentrantLock;

/*Reentrant Local is the implementation class of Lock interface which provides support same as synchornized keyword
* with more flexibility and enhancements
* - We can accquire same lock for multiple times without any issues.
* - Internally ReentrantLock threads have personal count which is increased based on the no of invocation of lock() method
* and vice versa on invocation of unlock() method, Eventually releasing the lock while personal count is 0
* -It also provides fairness policy i.e. Longest waiting thread will get the lock if it is available (i.e. First Come First Serve)
* - Default value of fairness is FALSE. */
public class ReentranLockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock= new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.lock();
        System.out.println("reentrant isLocked : "+reentrantLock.isLocked());
        System.out.println("reentrant isHeldByCurrentThread : "+reentrantLock.isHeldByCurrentThread());
        System.out.println("reentrant getQueueLength : "+reentrantLock.getQueueLength());
        reentrantLock.unlock();
        System.out.println("reentrant getHoldCount : "+reentrantLock.getHoldCount());
        System.out.println("reentrant isLocked : "+reentrantLock.isLocked());
        reentrantLock.unlock();
        System.out.println("reentrant isLocked : "+reentrantLock.isLocked());
        System.out.println("reentrant getHoldCount : "+reentrantLock.getHoldCount());
        System.out.println("reentrant isFair : "+reentrantLock.isFair());
    }
}
