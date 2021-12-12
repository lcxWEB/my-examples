package com.coder.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author: lichunxia
 * @create: 2021-03-29 08:55
 */
public class AtomicArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        int i = atomicIntegerArray.get(0);
        System.out.println(i);
        atomicIntegerArray.getAndAdd(0, 10);
        System.out.println(atomicIntegerArray.get(0));

        Long l1 = 127L;
        Long l2 = 127L;

        System.out.println(l1 == l2);

        Long l3 = 1270L;
        Long l4 = 1270L;
        System.out.println(l3 == l4);

        long l5 = 1270L;
        System.out.println(l3 == l5);
    }

}
