package com.hughes;

import java.io.Serializable;

/**
 * 远程调用信息封装
 * @author hughes-T
 * @since 2022/1/1 12:06
 */
public class RpcRequest implements Serializable {

    private String className;

    private String methodName;

    private Object[] params;

    private Class[] paramType;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamType() {
        return paramType;
    }

    public void setParamType(Class[] paramType) {
        this.paramType = paramType;
    }
}
