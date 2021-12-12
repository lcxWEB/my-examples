package com.coder.chapter2;

/**
 * -Xmx15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 * StringTable statistics:
 * Number of buckets       :     60013 =    480104 bytes, avg   8.000
 * Number of entries       :       938 =     22512 bytes, avg  24.000
 * Number of literals      :       938 =     61504 bytes, avg  65.569
 *
 * @author: lichunxia
 * @create: 2021-05-04 19:07
 */
public class StringGCTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String.valueOf(i).intern();
        }
    }
}
