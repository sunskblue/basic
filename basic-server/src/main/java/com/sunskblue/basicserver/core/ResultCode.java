package com.sunskblue.basicserver.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author sunshaokang
 * @date Created in 2020/11/4 3:57 下午
 * Description：响应码枚举，参考HTTP状态码的语义
 */
@ApiModel("通用响应返回 code")
public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    UNAUTHORIZED(401, "未认证（签名错误）"),
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private int code;

    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code(){
        return code;
    }
}
