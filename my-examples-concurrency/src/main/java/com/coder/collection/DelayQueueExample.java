package com.coder.collection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class DelayQueueExample {
 
    public static void main(String[] args) throws InterruptedException {
        DelayQueue queue = new DelayQueue();
        Delayed element1 = new DelayedElement(System.nanoTime() + 1000000);
        queue.put(element1);
        Delayed element2 = queue.take();
        System.out.println(element2);
    }
}
