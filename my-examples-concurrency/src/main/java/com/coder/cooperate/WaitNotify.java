package com.coder.cooperate;

import java.util.concurrent.TimeUnit;

/**
 * @author: lichunxia
 * @create: 2021-02-18 13:30
 */
public class WaitNotify {

    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            // try {
            //     TimeUnit.SECONDS.sleep(3); // notify放在wait前，程序无法唤醒无法执行
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "-----come in");
                try {
                    // 释放锁
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "\t" + "-----"  + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "-----被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    TimeUnit.SECONDS.sleep(3); // notify放在wait前，程序无法唤醒无法执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Wakes up a single thread that is waiting on this cooperate's monitor.
                lock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "-----通知");
            }
        }, "B").start();
    }
}
