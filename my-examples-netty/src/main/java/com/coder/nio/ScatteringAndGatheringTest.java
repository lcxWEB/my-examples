package com.coder.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author LiChunxia
 * @Date 2020/12/17  14:48
 * scattering: 将数据写入buffer时，可以使用buffer数组，依次写入
 * gathering：从buffer读数据时，可以采用buffer数组，依次读
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        // 绑定端口到socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;
        while (true) {
            int byteRead = 0;

            while (byteRead < messageLength) {
                long l = socketChannel.read(byteBuffers);
                byteRead = byteRead + (int) l;
                System.out.println("byteRead=" + byteRead);

                // 使用流打印
                for (ByteBuffer byteBuffer : byteBuffers) {
                    System.out.println("position=" + byteBuffer.position() + ", limit=" + byteBuffer.limit());
                }
            }

            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
            }

            int byteWrite = 0;
            while (byteWrite < messageLength) {
                long l = socketChannel.write(byteBuffers);
                byteWrite = (int) (byteWrite + l);
            }

            // 将所有buffer clear
            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.clear();
            }

            System.out.println("byteRead = " + byteRead + " byteWrite = " + byteWrite);

        }

    }


}
