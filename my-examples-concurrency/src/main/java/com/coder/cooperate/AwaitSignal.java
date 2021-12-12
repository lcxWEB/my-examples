package com.coder.cooperate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lichunxia
 * @create: 2021-02-18 13:45
 */
public class AwaitSignal {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            // try {
            //     TimeUnit.SECONDS.sleep(3); // notify放在wait前，程序无法唤醒无法执行
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "-----come in " + Thread.currentThread().getState());
                try {
                    // 释放锁
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "-----被唤醒 " + Thread.currentThread().getState());
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "-----通知  " + Thread.currentThread().getState());
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }
}
