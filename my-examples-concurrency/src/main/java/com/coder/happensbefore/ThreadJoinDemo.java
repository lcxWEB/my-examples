package com.coder.happensbefore;

import java.util.concurrent.TimeUnit;

/**
 * @author: lichunxia
 * @create: 2021-03-27 17:46
 */
public class ThreadJoinDemo {

    private int a = 10;

    public static void main(String[] args) {
        ThreadJoinDemo threadJoinDemo = new ThreadJoinDemo();

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            threadJoinDemo.a = ++threadJoinDemo.a;
            System.out.println(Thread.currentThread().getName() + " : " + threadJoinDemo.a);
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadJoinDemo.a);
    }
}

