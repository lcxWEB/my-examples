package com.coder.lock;

/**
 * @author: lichunxia
 * @create: 2021-03-30 08:19
 */

class MyThread0 extends Thread {

    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }

}

public class NotifyWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread0 myThread = new MyThread0();
        myThread.start();
        // 主线程睡眠3s
        Thread.sleep(3000);
        synchronized (myThread) {
            try {
                System.out.println("before wait");
                // 阻塞主线程
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
