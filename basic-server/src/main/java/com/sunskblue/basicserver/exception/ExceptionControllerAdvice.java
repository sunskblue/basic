package com.sunskblue.basicserver.exception;

import com.sunskblue.basicserver.core.ResultCode;
import com.sunskblue.basicserver.core.ResultWrapper;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sunshaokang
 * @date Created in 2020/11/5 12:45 下午
 * Description：全局异常处理类
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultWrapper MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
//        return objectError.getDefaultMessage();
        return new ResultWrapper()
                .setCode(ResultCode.PARAM_VALIED_FAILED)
                .setMessage(ResultCode.PARAM_VALIED_FAILED.msg()).setData(objectError.getDefaultMessage());
    }
    @ExceptionHandler(APIException.class)
    public ResultWrapper APIExceptionHandler(APIException e) {
        return new ResultWrapper()
                .setCode(ResultCode.FAIL)
                .setMessage("响应").setData(e.getMsg());
    }
}
