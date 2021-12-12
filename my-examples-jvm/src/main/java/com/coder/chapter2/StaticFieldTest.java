package com.coder.chapter2;

/**
 *  jdk7:
 *  -Xms200m -Xmx200m -XX:PermSize=300m -XX:MaxPermSize=300m -XX:+PrintGCDetails
 *
 *  jdk8:
 *  -Xms200m -Xmx200m -XX:MetaspaceSize=300m -XX:MaxMetaspaceSize=300m -XX:+PrintGCDetails
 *
 * @author: lichunxia
 * @create: 2021-05-04 09:42
 */
public class StaticFieldTest {

    private static byte[] arr = new byte[1024 * 1024 * 100]; // 年轻代放不下，直接放在老年代了

    public static void main(String[] args) {
        System.out.println(arr);

        // try {
        //     Thread.sleep(100000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }

}
