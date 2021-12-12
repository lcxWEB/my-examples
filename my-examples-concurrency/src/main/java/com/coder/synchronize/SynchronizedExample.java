package com.coder.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {

    public static void main(String[] args) {
        // 串行
        // SynchronizedExample e1 = new SynchronizedExample();
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.execute(() -> e1.func1());
        // executorService.execute(() -> e1.func1());
        // executorService.shutdown();

        // 交替运行
        // SynchronizedExample e1 = new SynchronizedExample();
        // SynchronizedExample e2 = new SynchronizedExample();
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.execute(() -> e1.func1());
        // executorService.execute(() -> e2.func1());
        // executorService.shutdown();

        // 交替运行
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());
        executorService.shutdown();
    }

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    public synchronized void funcs() {
        // ...
    }

    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized static void fun() {
        // ...
    }

}