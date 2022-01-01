package com.hughes.req;

import java.io.Serializable;

/**
 * @author hughes-T
 * @since 2021/12/31 11:12
 */
public class SayReqDto implements Serializable {

    private String paramsA;

    private String paramsB;

    public String getParamsA() {
        return paramsA;
    }

    public void setParamsA(String paramsA) {
        this.paramsA = paramsA;
    }

    public String getParamsB() {
        return paramsB;
    }

    public void setParamsB(String paramsB) {
        this.paramsB = paramsB;
    }
}
