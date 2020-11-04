package com.sunskblue.basicserver.core;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author sunshaokang
 * @date Created in 2020/11/4 3:57 下午
 * @param <T>
 * Description：接口返回统一封装
 */
public class ResultWrapper<T> {
    @ApiModelProperty("code")
    private int code;
    @ApiModelProperty("message")
    private String message;
    @ApiModelProperty("data")
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
