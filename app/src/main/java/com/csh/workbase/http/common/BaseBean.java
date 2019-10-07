package com.csh.workbase.http.common;

import java.io.Serializable;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/26
 */
public class BaseBean implements Serializable {

    private int code;
    private String msg;

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
}
