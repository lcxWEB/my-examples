package com.coder.juctool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: lichunxia
 * @create: 2021-02-18 14:15
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "-----come in " + System.currentTimeMillis());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "-----被唤醒 " + System.currentTimeMillis());

        }, "A");
        a.start();


        // try {
        //     TimeUnit.SECONDS.sleep(3); // notify放在wait前，程序无法唤醒无法执行
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "-----通知");
        }, "B").start();
    }

}
