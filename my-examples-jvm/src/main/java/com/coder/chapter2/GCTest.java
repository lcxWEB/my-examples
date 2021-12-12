package com.coder.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms9M -Xmx9M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author: lichunxia
 * @create: 2021-05-03 09:54
 */
public class GCTest {


    public static void main(String[] args) {
        int i = 0;

        try {
            List<String> list = new ArrayList<>();
            String a = "atguigu.com";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
                Thread.sleep(1000);
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("遍历次数为：" + i);
        }
    }


}
