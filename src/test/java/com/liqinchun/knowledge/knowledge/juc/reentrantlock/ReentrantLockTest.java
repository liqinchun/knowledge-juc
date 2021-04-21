package com.liqinchun.knowledge.knowledge.juc.reentrantlock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private ReentrantLock reentrantLock = new ReentrantLock();

    /** */
    @Test
    public void lockTest() {
        ReentrantLock nonFairLock = new ReentrantLock();
        ReentrantLock fairLock = new ReentrantLock(true);
        Runnable t1 = new LockThread(nonFairLock, "t1");
        Runnable t2 = new LockThread(nonFairLock, "t2");
        Runnable t3 = new LockThread(fairLock, "t3");
        Runnable t4 = new LockThread(fairLock, "t4");
        for (int i = 0; i < 100; i++) {
            t1.run();
            t2.run();
            t3.run();
            t4.run();
        }
    }
}

class LockThread implements Runnable {

    private Lock lock;
    private String threadName;

    public LockThread(Lock lock, String name) {
        this.lock = lock;
        this.threadName = name;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(System.currentTimeMillis());
            System.out.println(threadName);
        } finally {
            lock.unlock();
        }
    }
}
