package com.hughes;

/**
 * @author hughes-T
 * @since 2022/1/1 10:49
 */
public class App {

    public static void main(String[] args) {
        IHelloService helloService = new HelloServiceImpl();
        RpcProxyService.publisher(helloService,8099);
    }
}
