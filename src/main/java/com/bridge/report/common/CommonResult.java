package com.bridge.report.common;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {

    Long code;
    String msg;
    T body;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static <T> CommonResult<T> succeed(T body)  {
            var commonResult = new CommonResult<T>();
            commonResult.setBody(body);
            commonResult.setMsg("操作成功");
            commonResult.setCode(200L);
            return commonResult;
        }

    public static <T> CommonResult<T> error(T body)  {
            var commonResult = new CommonResult<T>();
            commonResult.setBody(body);
            commonResult.setMsg("请求错误");
            commonResult.setCode(500L);
            return commonResult;
        }

}
