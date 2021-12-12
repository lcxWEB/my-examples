package com.coder.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author: lichunxia
 * @create: 2021-03-29 13:21
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
