package com.hughes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hughes-T
 * @since 2021/12/31 11:22
 */
public class RpcProxyService {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void publisher(Object service, int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("接收到来自" + socket.getPort() +"的连接");
                executorService.submit(new NetInvokeRunner(socket, service));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

}
