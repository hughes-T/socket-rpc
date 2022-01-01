package com.hughes;

import com.hughes.req.SayReqDto;
import com.hughes.resp.SayRespDto;

/**
 * @author hughes-T
 * @since 2021/12/31 11:19
 */
public class HelloServiceImpl implements IHelloService{

    public SayRespDto say(SayReqDto sayReqDto) {
        SayRespDto sayRespDto = new SayRespDto();
        sayRespDto.setParamsAB(sayReqDto.getParamsA() + sayReqDto.getParamsB());
        return sayRespDto;
    }

}
