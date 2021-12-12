package com.coder.happensbefore;

/**
 * @author: lichunxia
 * @create: 2021-03-27 17:33
 */
public class ThreadStartDemo {

    private int a = 10;

    public static void main(String[] args) {
        ThreadStartDemo threadStartDemo = new ThreadStartDemo();
        threadStartDemo.a = ++threadStartDemo.a;

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " : " + threadStartDemo.a);
            }).start();
        }

    }
}
