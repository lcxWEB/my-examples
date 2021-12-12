package com.coder.juctool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: lichunxia
 * @create: 2021-04-03 16:48
 */
public class CountDownLatchFive {

    private List list = new ArrayList();

    public static void main(String[] args) {

        CountDownLatchFive latchFive = new CountDownLatchFive();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 begin");
            if (latchFive.list.size() != 5) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end");
        }).start();

        new Thread(() -> {
            System.out.println("t1 begin");
            for (int i = 0; i < 10; i++) {
                latchFive.list.add(i);
                System.out.println("add " + i);
                if (latchFive.list.size() == 5) {
                    countDownLatch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 end");
        }).start();

    }

}
