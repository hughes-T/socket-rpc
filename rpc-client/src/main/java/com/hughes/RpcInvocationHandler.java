package com.hughes;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author hughes-T
 * @since 2022/1/1 12:19
 */
public class RpcInvocationHandler implements InvocationHandler {

    private String host;

    private int port;

    public RpcInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke执行了....");
        System.out.println(method);
        System.out.println(method.getDeclaringClass().getName());
        System.out.println(method.getName());
        System.out.println(args);
        System.out.println(method.getParameterTypes());

        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParams(args);
        rpcRequest.setParamType(method.getParameterTypes());
        //远程调用
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Object ret = null;
        try {
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(rpcRequest);
            oos.flush();
            System.out.println("客户端写出数据成功");

            ois = new ObjectInputStream(socket.getInputStream());
            ret =  ois.readObject();
            System.out.println("客户端获取数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                oos.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            try{
                ois.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            try{
                socket.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        return ret;
    }


}
