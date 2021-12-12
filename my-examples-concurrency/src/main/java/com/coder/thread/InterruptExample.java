package com.coder.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InterruptExample {

    public static void main(String[] args) {
        Thread thread1 = new MyThread1();
        thread1.start();
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        thread1.interrupt();
        System.out.println("Main run");

        Thread thread2 = new MyThread2();
        thread2.start();
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        thread2.interrupt();

        // Executor的中断
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");

        executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            // ..
            System.out.println("future running");
        });
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        future.cancel(true);
        executorService.shutdownNow();
    }


    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread1 run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
                System.out.println("Thread2 running");

            }
            System.out.println("Thread2 end");
        }
    }

}