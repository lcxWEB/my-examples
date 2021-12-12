package com.coder.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author: lichunxia
 * @create: 2021-03-29 17:03
 */
public class TestAtomicIntegerFieldUpdater {

    public static void main(String[] args) {
        TestAtomicIntegerFieldUpdater tIA = new TestAtomicIntegerFieldUpdater();
        tIA.doIt();
    }

    public AtomicIntegerFieldUpdater<DataDemo> updater(String name) {
        return AtomicIntegerFieldUpdater.newUpdater(DataDemo.class, name);

    }

    public void doIt() {
        DataDemo data = new DataDemo();
        System.out.println("publicVar = " + updater("publicVar").getAndAdd(data, 2));

        System.out.println("publicVar = " + updater("publicVar").get(data));
        // System.out.println("finalVar = " + updater("finalVar").get(data)); //Must be volatile type
        /*
         * 由于在DataDemo类中属性value2/value3,在TestAtomicIntegerFieldUpdater中不能访问
         * */
        System.out.println("protectedVar = " + updater("protectedVar").getAndAdd(data, 2));
        System.out.println("protectedVar = " + updater("protectedVar").get(data));
        // System.out.println("privateVar = " + updater("privateVar").getAndAdd(data, 2));

        // System.out.println("staticVar = " + updater("staticVar").getAndIncrement(data));//报java.lang.IllegalArgumentException
        /*
         * 下面报异常：must be integer
         * */
        System.out.println("integerVar = " + updater("integerVar").getAndIncrement(data)); //Must be integer type
        // System.out.println("longVar = " + updater("longVar").getAndIncrement(data)); //Must be integer type
    }

}

class DataDemo {

    public volatile static int staticVar = 10;
    public final int finalVar = 11;
    public volatile int publicVar = 3;
    public volatile Integer integerVar = 19;
    public volatile Long longVar = 18L;
    protected volatile int protectedVar = 4;

    private volatile int privateVar = 5;

}
