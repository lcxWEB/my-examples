package com.coder.nio;

import java.nio.IntBuffer;

/**
 * @author: lichunxia
 * @create: 2020-12-16 23:26
 */
public class BasicBuffer {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // 将buffer转换，读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

    }
}
