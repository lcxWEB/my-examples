package com.coder.juctool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyThreadForCyclic extends Thread {
    private CyclicBarrier cb;

    public MyThreadForCyclic(String name, CyclicBarrier cb) {
        super(name);
        this.cb = cb;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to await");
        try {
            cb.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        CyclicBarrier cb = new CyclicBarrier(3, new Thread("barrierAction") {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " barrier action");

            }
        });
        MyThreadForCyclic t1 = new MyThreadForCyclic("t1", cb);
        MyThreadForCyclic t2 = new MyThreadForCyclic("t2", cb);
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + " going to await");
        cb.await();
        System.out.println(Thread.currentThread().getName() + " continue");

    }

}
