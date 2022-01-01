package com.hughes;

import com.hughes.req.SayReqDto;

/**
 * @author hughes-T
 * @since 2022/1/1 12:15
 */
public class App {

    public static void main(String[] args) {
        new Thread(()->{
            RpcProxyClient rpcProxyClient = new RpcProxyClient();
            IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8099);
            final SayReqDto sayReqDto = new SayReqDto();
            sayReqDto.setParamsA("阿");
            sayReqDto.setParamsB("伟");
            System.out.println(helloService.say(sayReqDto));
        }).start();
    }

}
