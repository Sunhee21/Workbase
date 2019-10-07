package com.csh.lib_framwork.http.gson;

import java.io.IOException;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/26
 */
public class DataResultException extends IOException {

    private int code;
    private String msg;
    private Object obj;

    public DataResultException(int code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
