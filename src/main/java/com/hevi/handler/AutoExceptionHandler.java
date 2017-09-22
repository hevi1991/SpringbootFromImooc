package com.hevi.handler;

import com.hevi.domain.Result;
import com.hevi.enums.ResultEnum;
import com.hevi.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常自动捕获
 * Created by Hevi on 2017/9/22.
 */
@ControllerAdvice//控制器捕获
public class AutoExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)//捕获的错误列席
    @ResponseBody
    public Result handle(Exception e){
        logger.error(e.getMessage());
        if (e instanceof GirlException){//instanceof 查看是否为此类实例
            GirlException girlException = (GirlException) e;
            return new Result(girlException.getCode(), girlException.getMessage());
        }
        return new Result(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

}
