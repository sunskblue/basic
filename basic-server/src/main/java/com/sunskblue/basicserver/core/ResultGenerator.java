package com.sunskblue.basicserver.core;

/**
 * @author sunshaokang
 * @date Created in 2020/11/4 3:57 下午
 * Description：响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResultWrapper genSuccessResult() {
        return new ResultWrapper()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> ResultWrapper<T> genSuccessResult(T data) {
        return new ResultWrapper()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResultWrapper genFailResult(String message) {
        return new ResultWrapper()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
