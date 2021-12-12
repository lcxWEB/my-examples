package com.coder.thread;

import java.util.concurrent.Callable;

/**
 * @author: lichunxia
 * @create: 2021-02-18 10:50
 */
public class MyCallThread implements Callable<Integer> {

    private int i;

    @Override
    public Integer call() throws Exception {
        for (; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
        return i;
    }

}
