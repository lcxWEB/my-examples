package com.coder.collection;

import java.util.concurrent.ConcurrentLinkedQueue;

class PutThread extends Thread {

    private ConcurrentLinkedQueue<Integer> clq;

    public PutThread(ConcurrentLinkedQueue<Integer> clq) {
        this.clq = clq;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("add " + i);
                clq.add(i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetThread extends Thread {

    private ConcurrentLinkedQueue<Integer> clq;

    public GetThread(ConcurrentLinkedQueue<Integer> clq) {
        this.clq = clq;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("poll " + clq.poll());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<Integer>();
        PutThread p1 = new PutThread(clq);
        GetThread g1 = new GetThread(clq);

        p1.start();
        g1.start();

    }
}
