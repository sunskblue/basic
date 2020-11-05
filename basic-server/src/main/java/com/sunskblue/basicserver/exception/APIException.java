package com.sunskblue.basicserver.exception;

import lombok.Getter;

/**
 * @author sunshaokang
 * @date Created in 2020/11/5 12:55 下午
 * Description：自定义异常处理
 */
@Getter
public class APIException extends RuntimeException {
    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
