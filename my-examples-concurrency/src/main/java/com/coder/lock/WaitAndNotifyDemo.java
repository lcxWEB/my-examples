package com.coder.lock;

class MyThread extends Thread {

    public void run() {
        // 获取到锁
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}


/**
 * 使用wait/notify实现同步时，必须先调用wait，后调用notify，
 * 如果先调用notify，再调用wait，将起不了作用
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        synchronized (myThread) {
            try {
                myThread.start();
                // 主线程睡眠3s
                // 不释放锁
                Thread.sleep(3000);
                System.out.println("before wait");
                // 阻塞主线程，释放锁
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}