package com.coder.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lichunxia
 * @create: 2021-04-09 17:33
 */
public class ThreadPoolTest {

    private static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });

        threadPoolExecutor.submit(() -> {
            System.out.println("hello");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("exit");
        });

        threadPoolExecutor.shutdownNow();
        threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
        // threadPoolExecutor.shutdownNow();

        int i = ai.get();
        new Thread(() -> {
            int i1 = ai.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " : " + i1);
        }).start();
        System.out.println(i);
        Thread.sleep(1000);
        System.out.println(ai.get());

    }
}
