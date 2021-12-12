package com.coder.nio;

import java.nio.ByteBuffer;

/**
 * @Author LiChunxia
 * @Date 2020/12/17  14:22
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.flip();

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass()); //java.nio.HeapByteBufferR

        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

        readOnlyBuffer.put((byte) 2); // ReadOnlyBufferException
    }

}
