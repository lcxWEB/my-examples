package com.coder.threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lichunxia
 * @create: 2021-04-09 13:06
 */
public class NetworkService implements Runnable {

    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize)
            throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                pool.execute(new Handler(serverSocket.accept()));
            }
        } catch (IOException ex) {
            pool.shutdown();
        }
    }


}

class Handler implements Runnable {

    private final Socket socket;

    Handler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // read and service request on socket
    }
}
