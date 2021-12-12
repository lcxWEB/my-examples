package com.coder.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author LiChunxia
 * @Date 2020/12/17  14:39
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        /**
         * 参数1：FileChannel.MapMode.READ_WRITE -- 读写模式
         * 参数2：0 -- 可以直接修改的起始位置
         * 参数3:5 -- 映射到内存的大小(不是索引位置)，将1.txt的多少字节映射到内存，可以直接修改的范围是0-5
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        mappedByteBuffer.put(5, (byte) '9'); // IndexOutOfBoundsException

        randomAccessFile.close();
        System.out.println("修改完成~~~");

    }

}
