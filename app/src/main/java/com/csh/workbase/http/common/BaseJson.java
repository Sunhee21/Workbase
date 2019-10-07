package com.csh.workbase.http.common;

/**
 * @author sunhee
 * @intro
 * @date 2019/7/25
 */
public class BaseJson<T> extends BaseBean  {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
