package com.fh.common;

public enum ResponseEnum {

    USERNAME_IS_NULL(1111, "用户名或密码不能为空"),
    USER_IS_BULL(1000, "用户不存在");

    private int code;
    private String msg;

    private ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
