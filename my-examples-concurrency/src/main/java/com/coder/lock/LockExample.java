package com.coder.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final byte b1 = 1;
        final byte b2 = 3;
        byte b3 = b1 + b2; // b1和b2必final
        // byte b1=1;
        // byte b2=3;
        // byte b3=b1+b2;
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> lockExample.func());
        executorService.execute(() -> lockExample.func());
        executorService.shutdown();
    }

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }

}