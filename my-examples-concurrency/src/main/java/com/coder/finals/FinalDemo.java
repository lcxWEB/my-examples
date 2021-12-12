package com.coder.finals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FinalDemo {

    private static FinalDemo finalDemo;
    private final int b; //final域
    private int a;  //普通域

    public FinalDemo() {
        a = 1; // 1. 写普通域
        b = 2; // 2. 写final域
    }

    public static void writer() {
        finalDemo = new FinalDemo();
    }

    public static void reader() {
        FinalDemo demo = finalDemo; // 3.读对象引用
        int a = demo.a;    //4.读普通域
        int b = demo.b;    //5.读final域
        System.out.println("a = " + a + "; b = " + b);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <1000 ; i++) {
            executorService.execute(() -> FinalDemo.writer());
            executorService.execute(() -> FinalDemo.reader());
        }
        // executorService.shutdown();
    }
}