package com.coder.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM的发生表示了此刻JVM堆内存告罄，不能分配出更多的资源，或者gc回收效率不可观。
 * 一个线程的OOM，在一定程度的并发下，若此时其他线程也需要申请堆内存，那么其他线程也会因为申请不到内存而OOM，甚至连锁反应导致整个JVM的退出。
 * <p>
 * 以上示例没有导致JVM退出的原因在于，线程通过往局部变量集合中不断加入对象，产生OOM。线程因异常退出后，集合中的对象由于引用不可达，会被gc，这样就有了足够的堆内存供其他线程使用。
 * <p>
 * 若示例中的list是一个“全局”的类static变量，那么即使线程退出，内存也得不到释放。这时其他线程如果不断再申请堆内存资源，就会造成连锁反应导致JVM退出。
 */
class OOMObject {
    // 为快速发生oom，设置堆大小; VM args: -Xms20m -Xmx20m
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            List<OOMObject> list = new ArrayList<>();
            while (true) {
                list.add(new OOMObject());
            }
        }).start();

        while (true) {
            System.out.println(Thread.currentThread().getName() + " continuing...");
            Thread.sleep(1000L);
        }
    }
}

