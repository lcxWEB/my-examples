package com.coder.threadlocal;

/**
 * @author: lichunxia
 * @create: 11/21/21 12:11 PM
 */
public class InheritTest {


    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("main");


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());

            }
        });
        thread.start();

    }

}
