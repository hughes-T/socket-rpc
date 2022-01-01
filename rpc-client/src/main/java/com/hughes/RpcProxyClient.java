package com.hughes;

import java.lang.reflect.Proxy;

/**
 * @author hughes-T
 * @since 2022/1/1 12:17
 */
public class RpcProxyClient {

    public <T> T clientProxy(Class<T> proxyClassType , String host , int port){
       return (T) Proxy.newProxyInstance(proxyClassType.getClassLoader(),new Class[]{proxyClassType},new RpcInvocationHandler(host,port));
    }
}
