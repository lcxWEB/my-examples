package com.coder.chapter2;

import java.util.ArrayList;
import java.util.Random;

/**
 *  -Xms600M -Xmx600M -XX:+PrintGCDetails -XX:SurvivorRatio=8(必须显式指定)
 *
 * @author: lichunxia
 * @create: 2021-05-03 09:09
 */
public class HeapInstanceTest {

    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
