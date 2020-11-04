package com.sunskblue.basicserver.core;

import com.google.gson.Gson;


/**
 * 接口返回统一封装
 *
 * @param <T>
 */
public class ResultWrapper<T> {
    private int code;
    private String message;
    private T data;

    public ResultWrapper setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResultWrapper setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultWrapper setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}