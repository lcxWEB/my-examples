package com.coder.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lichunxia
 * @create: 2020-12-16 23:26
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端启动了");

        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("收到客户端连接");

            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread());
                    handler(socket);
                }
            });
        }


    }

    private static void handler(Socket socket) {

        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
