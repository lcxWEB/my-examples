package com.coder.nio;

import java.nio.ByteBuffer;

/**
 * @Author LiChunxia
 * @Date 2020/12/17  12:38
 */
public class NIOByteBufferPutGet {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(12);
        byteBuffer.putLong(9);
        byteBuffer.putChar('你');
        byteBuffer.putShort((short) 5);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getLong()); // BufferUnderflowException
//        System.out.println(byteBuffer.getShort());

    }

}
