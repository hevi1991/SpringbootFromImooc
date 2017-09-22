package com.hevi.exception;

/**
 * 自定义异常
 * Created by Hevi on 2017/9/22.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
