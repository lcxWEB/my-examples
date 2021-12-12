package com.coder.chapter2;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;

/**
 * @author: lichunxia
 * @create: 2021-05-08 10:02
 */
public class ScannerTest {

    public static void main(String[] args) {
        System.out.println(1073741824 / 1024/ 1024);
        // Scanner scanner = new Scanner(System.in);
        // String info = scanner.next();

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println(heapMemoryUsage);
    }

}
