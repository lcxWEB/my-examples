package com.coder.thread;

/**
 * Created by lichunxia on 2020-03-25 14:47
 */
public class Main {

    public static void main(String[] args) {
        int i = 1;
        i++;

        Object object = new Object();
        // new Thread(() -> {
        //     try {
        //         Thread.sleep(1000);
        //         System.out.println("结束===");
        //     } catch (InterruptedException e) {
        //         // e.printStackTrace();
        //     }
        // }).start();

        try {
            new Thread(() -> {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               throw new RuntimeException("异常===");
            }).start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            a();
        } catch (Exception e) {
            // System.out.println(e.getMessage());
        }
        System.out.println("main === ");
        // System.exit(0);
    }

    private static void a() {
        b();
        int j = 0;
        j--;
        throw new RuntimeException("a()====");
    }

    private static void b() {
        c();
    }

    private static void c() {
        d();
    }

    private static void d() {

    }
}
