package com.coder.chapter2;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @author: lichunxia
 * @create: 2021-05-04 20:14
 */
public class BufferTest {

    private static final int BUFFER = 1024 * 1024 * 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER);
        System.out.println("直接内存分配完毕");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("开始释放内存");
        byteBuffer = null;

        System.gc();
        scanner.next();
    }
}
