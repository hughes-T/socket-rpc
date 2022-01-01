package com.hughes;

import com.hughes.req.SayReqDto;
import com.hughes.resp.SayRespDto;

/**
 * @author hughes-T
 * @since 2021/12/31 11:12
 */
public interface IHelloService {

    SayRespDto say(SayReqDto sayReqDto);

}
