package com.hughes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author hughes-T
 * @since 2021/12/31 11:26
 */
public class NetInvokeRunner implements Runnable {

    private final Socket socket;

    private final Object service;

    public NetInvokeRunner(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) ois.readObject();
            System.out.println("接收到请求数据");
            Object ret = invoke(rpcRequest);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(ret);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws Exception{
        Class clazz = Class.forName(rpcRequest.getClassName());
        Method method = clazz.getDeclaredMethod(rpcRequest.getMethodName(), rpcRequest.getParamType());
        return method.invoke(service, rpcRequest.getParams());
    }
}
