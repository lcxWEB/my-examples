package com.coder.collection;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: lichunxia
 * @create: 2021-04-02 19:34
 */
public class LinkedBlockingDequeDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        deque.addFirst("1");
        deque.addLast("2");

        String two = deque.takeLast();
        System.out.println(two);
        String one = deque.takeFirst();
        System.out.println(one);

    }
}
