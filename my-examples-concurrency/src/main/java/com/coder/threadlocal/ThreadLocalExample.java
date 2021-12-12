package com.coder.threadlocal;

/**
 * @author: lichunxia
 * @create: 2021-03-21 21:03
 */
public class ThreadLocalExample {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        //     Thread thread1 = new Thread(() -> {
        //         threadLocal.set(1);
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         System.out.println(threadLocal.get());
        //         threadLocal.remove();
        //     });
        //
        //     Thread thread2 = new Thread(() -> {
        //         threadLocal.set(2);
        //         threadLocal.remove();
        //     });
        //
        //     thread1.start();
        //     thread2.start();


        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
        s = s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

}
