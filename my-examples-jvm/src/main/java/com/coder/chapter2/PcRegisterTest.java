package com.coder.chapter2;

/**
 * -Xms900M -Xmx900M -XX:+PrintGCDetails -XX:SurvivorRatio=8(必须显式指定)
 * -XX:-UseAdaptiveSizePolicy(没用！！ 关闭自适应依然是6：1：1)
 *
 * @author: lichunxia
 * @create: 2021-04-27 09:17
 */
public class PcRegisterTest {

    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = i + j;

        String s = "abc";
        System.out.println(i);
        System.out.println(k);

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
