package com.coder.juctool;

import java.util.concurrent.*;

/**
 * Created by lichunxia on 2020-04-03 11:52
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("看大夫成功，大夫给开了些药单子");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // new Thread(() -> {
        //     try {
        //         TimeUnit.SECONDS.sleep(3);
        //         System.out.println("看大夫成功，大夫给开了些药单子");
        //         countDownLatch.countDown();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }).start();
        executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("排队成功，可以开始交费");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // new Thread(() -> {
        //     try {
        //         TimeUnit.SECONDS.sleep(5);
        //         System.out.println("排队成功，可以开始交费");
        //         countDownLatch.countDown();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((ExecutorService) executor).shutdown();
        System.out.println("time -- " + (System.currentTimeMillis() - begin));

    }
}
