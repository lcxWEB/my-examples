package com.coder.juctool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Counter {

    private AtomicStampedReference<Integer> count = new AtomicStampedReference<>(0, 0);

    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> counter.increment());
        }
        executorService.shutdown();
        System.out.println(counter.getCount());
    }

    public int getCount() {
        return count.getReference();
    }

    public int increment() {
        int[] stamp = new int[1];
        while (true) {
            Integer value = count.get(stamp); //同时获取时间戳和数据，防止获取到数据和版本不是一致的
            int newValue = value + 1;
            boolean writeOk = count.compareAndSet(value, newValue, stamp[0], stamp[0] + 1);
            if (writeOk) {
                return newValue;
            }
        }
    }

    public int decrement() {
        int[] stamp = new int[1];
        while (true) {
            Integer value = count.get(stamp);//同时获取时间戳和数据，防止获取到数据和版本不是一致的
            int newValue = value - 1;
            boolean writeOk = count.compareAndSet(value, newValue, stamp[0], stamp[0] + 1);
            if (writeOk) {
                return newValue;
            }
        }
    }
}