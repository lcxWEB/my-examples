package com.coder.jmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * -Xms60M -Xmx60M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/lichunxia/Documents/mydata/gctest66.hprof
 *
 * @author: lichunxia
 * @create: 2021-05-08 13:03
 */
public class GCTest {

    public static void main(String[] args) {

        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();


        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            byte[] arr = new byte[100 * 1024];
            list.add(arr);

            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
