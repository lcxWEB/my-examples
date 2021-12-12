package com.coder.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class AbstractQueuedSynchonizerDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        MyThread0 t1 = new MyThread0("t1", lock);
        MyThread0 t2 = new MyThread0("t2", lock);
        t1.start();
        t2.start();
    }

    private static class MyThread0 extends Thread {
        private Lock lock;

        public MyThread0(String name, Lock lock) {
            super(name);
            this.lock = lock;
        }

        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread() + " running");
            } finally {
                lock.unlock();
            }
        }
    }
}