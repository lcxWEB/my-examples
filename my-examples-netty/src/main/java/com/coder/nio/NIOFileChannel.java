package com.coder.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author LiChunxia
 * @Date 2020/12/17  11:15
 */
public class NIOFileChannel {

    public static void main(String[] args) throws Exception {
//        write();
//        read();
//        copyFile();
        transFrom();
    }

    private static void transFrom() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.jpg");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("a1.jpg");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        fileChannel02.transferFrom(fileChannel01, 0, fileChannel01.size());

        fileChannel01.close();
        fileChannel02.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void copyFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            // 复位
            byteBuffer.clear();
            int read = fileChannel01.read(byteBuffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }
            // 切换
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void write() throws IOException {
        String str = "hello";
        // outputstream里面有个channel
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\素材\\nio.text");
        // 获取filechannel
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // src 放入bytebuffer
        byteBuffer.put(str.getBytes());
        // 对bytebuffer进行flip
        byteBuffer.flip();
        // 将bytebuffer写入channel
        fileChannel.write(byteBuffer);
        // 关闭流
        fileOutputStream.close();
    }

    private static void read() throws IOException {
        // outputstream里面有个channel
        String filePath = "C:\\素材\\nio.text";
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取filechannel
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        // 将channel写入bytebuffer
        fileChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        // 关闭流
        fileInputStream.close();
    }

}
