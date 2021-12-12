package com.coder.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: lichunxia
 * @create: 2021-03-30 07:57
 */

class MyThread2 extends Thread {
    private Object object;

    public MyThread2(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        // 释放许可，因为object是主线程，所以针对主线程
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}

public class UnparkParkDemo {

    public static void main(String[] args) {
        // object设置为主线程
        MyThread2 myThread = new MyThread2(Thread.currentThread());
        myThread.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可，针对主线程
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }

}
