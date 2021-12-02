package com.jiashn.projectsso.common;

import com.jiashn.projectsso.util.ResultVO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.el.MethodNotFoundException;
import java.beans.PropertyVetoException;

/**
 * @Author: jiangjs
 * @Description: 统一异常处理
 * @Date: 2021/12/2 15:28
 **/
@RestControllerAdvice
public class UnificationExceptionHandle {

    /**
     * 方法参数校验异常
     * @param exception 异常
     * @return 返回校验结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<?> methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException exception){
        ObjectError objectError = exception.getAllErrors().get(0);
        String exceptionMsg = objectError.getDefaultMessage();
        return ResultVO.error(2001,exceptionMsg);
    }

    @ExceptionHandler(MethodNotFoundException.class)
    public ResultVO<?> methodNotFoundExceptionHandle(MethodNotFoundException exception){
        String msg = "方法找不到:" + exception.getMessage();
        return ResultVO.error(4004,msg);
    }
}