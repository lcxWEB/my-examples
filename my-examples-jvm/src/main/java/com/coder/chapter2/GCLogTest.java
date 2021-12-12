package com.coder.chapter2;

/**
 *
 *  -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -Xloggc:./logs/gc.log
 *
 *  -XX:+UseSerialGC
 *
 * @author: lichunxia
 * @create: 2021-05-08 08:41
 */
public class GCLogTest {

    private static final int _1MB = 1024 * 1024;


    private static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];

    }

    public static void main(String[] args) {
        testAllocation();
    }

}
