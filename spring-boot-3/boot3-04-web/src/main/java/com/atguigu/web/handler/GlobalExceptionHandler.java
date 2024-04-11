package com.atguigu.web.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice   // 这个类是集中处理所有 @Controller 发生的错误
public class GlobalExceptionHandler {

    /**
     * 1、@ExceptionHandler 标识一个方法处理错误，默认只能处理这个类发生的错误
     * 2、@ControllerAdvice 统一处理所有错误
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {

        return "报错统一处理，原因：" + e.getMessage();
    }


}
