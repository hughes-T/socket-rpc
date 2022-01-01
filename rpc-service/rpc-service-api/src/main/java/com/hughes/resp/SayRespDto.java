package com.hughes.resp;

import java.io.Serializable;

/**
 * @author hughes-T
 * @since 2021/12/31 11:13
 */
public class SayRespDto implements Serializable {

    private String paramsAB;

    public String getParamsAB() {
        return paramsAB;
    }

    public void setParamsAB(String paramsAB) {
        this.paramsAB = paramsAB;
    }

    @Override
    public String toString() {
        return "SayRespDto{" +
                "paramsAB='" + paramsAB + '\'' +
                '}';
    }
}
