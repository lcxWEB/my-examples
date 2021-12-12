package com.coder.collection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class PutThreadForList extends Thread {
    private CopyOnWriteArrayList<Integer> cowal;

    public PutThreadForList(CopyOnWriteArrayList<Integer> cowal) {
        this.cowal = cowal;
    }

    public void run() {
        try {
            for (int i = 100; i < 110; i++) {
                cowal.add(i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> cowal = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            cowal.add(i);
        }
        PutThreadForList p1 = new PutThreadForList(cowal);
        p1.start();
        Iterator<Integer> iterator = cowal.iterator();
        while (iterator.hasNext()) {
            System.out.println(Thread.currentThread().getName() + " : " + iterator.next() + " ");
        }
        System.out.println();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        iterator = cowal.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}
