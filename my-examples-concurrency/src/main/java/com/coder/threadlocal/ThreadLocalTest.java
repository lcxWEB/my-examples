package com.coder.threadlocal;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lichunxia on 2020-04-06 12:28
 */
public class ThreadLocalTest {

    private int i = 0;

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1), Thread::new, new ThreadPoolExecutor.AbortPolicy());
        // threadPoolExecutor.allowCoreThreadTimeOut(true);

        threadPoolExecutor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set("task 1");
            System.out.println(Thread.currentThread().getName()  + " executor1 " + threadLocal.get());
        });

        // try {
        //     TimeUnit.SECONDS.sleep(2);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        threadPoolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " executor2 " + threadLocal.get());
        });

        threadPoolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " executor3 " + threadLocal.get());
        });

        threadPoolExecutor.shutdown();


    }


}
