package com.coder.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: lichunxia
 * @create: 2021-03-30 08:06
 */

class MyThread3 extends Thread {

    private Object object;

    public MyThread3(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before interrupt");
        try {
            // 休眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        // 中断线程
        thread.interrupt();
        System.out.println("after interrupt");
    }
}

public class InterruptDemo {

    public static void main(String[] args) {
        MyThread3 myThread = new MyThread3(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
