package com.sunskblue.basicserver.core;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @param <T> Description：接口返回统一封装
 * @author sunshaokang
 * @date Created in 2020/11/4 3:57 下午
 */
@ApiModel(value = "通用响应返回对象")
public class ResultWrapper<T> {
    @ApiModelProperty(value = "code")
    private int code;
    @ApiModelProperty(value = "message")
    private String message;
    @ApiModelProperty(value = "data")
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
