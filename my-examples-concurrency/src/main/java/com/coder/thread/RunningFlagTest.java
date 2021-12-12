package com.coder.thread;

/**
 * @author: lichunxia
 * @create: 2021-02-18 13:00
 */
public class RunningFlagTest {

    public static void main(String[] args) throws InterruptedException {
        HelloThread1 t = new HelloThread1();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false
    }

}

class HelloThread1 extends Thread {

    public volatile boolean running = true;

    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }

}
