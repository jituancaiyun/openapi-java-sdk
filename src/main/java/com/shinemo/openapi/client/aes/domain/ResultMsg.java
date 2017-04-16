package com.shinemo.openapi.client.aes.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by yuanjian on 3/30/17.
 */
public class ResultMsg<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> ResultMsg<T> success(T data) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.data = data;
        resultMsg.code = 200;
        return resultMsg;
    }

    public static <T> ResultMsg<T> error(int code, String msg) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.msg = msg;
        resultMsg.code = code;
        return resultMsg;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    public Integer getCode() {
        return code;
    }

    public ResultMsg<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultMsg<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
