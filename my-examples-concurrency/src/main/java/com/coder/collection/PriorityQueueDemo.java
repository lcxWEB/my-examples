package com.coder.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author: lichunxia
 * @create: 2021-04-02 19:39
 */
public class PriorityQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new PriorityBlockingQueue();
        //String implements java.lang.Comparable
        queue.put("Value");
        queue.put("A");
        String value = (String) queue.take();
        System.out.println(value);
        String value1 = (String) queue.take();
        System.out.println(value1);
    }
}
