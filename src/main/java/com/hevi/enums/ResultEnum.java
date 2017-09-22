package com.hevi.enums;

/**
 * 自定义状态枚举
 * Created by Hevi on 2017/9/22.
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    NOT_ENOUGH_AGE(100,"未成年"),
    ACTION_FAILD(99,"操作失败")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
