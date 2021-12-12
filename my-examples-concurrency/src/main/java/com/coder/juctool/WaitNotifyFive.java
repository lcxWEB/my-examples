package com.coder.juctool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lichunxia
 * @create: 2021-04-03 12:10
 */
public class WaitNotifyFive {

    private List list = new ArrayList();


    public static void main(String[] args) {

        Object lock = new Object();

        WaitNotifyFive t = new WaitNotifyFive();


        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动");
                if (t.list.size() != 5) {
                    try {
                        lock.wait();
                        System.out.println("t2 结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "Thread2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 启动");
                for (int i = 0; i < 10; i++) {
                    t.list.add(i);
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    if (t.list.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "Thread1").start();

    }

}
