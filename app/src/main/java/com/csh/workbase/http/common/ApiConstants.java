package com.csh.workbase.http.common;

/**
 * 应用接口常量
 *
 * @author chenshanghui
 * @intro
 * @date 2019/8/16
 */
public class ApiConstants {

    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_FAIL = 1;
    public static final int GOODS_TYPE_GUAPAI = 1;
    public static final int GOODS_TYPE_TICKET = 2;



    public static final int DELEGATE_BUY = 1;
    public static final int DELEGATE_SELL = 2;


    public static final int SELLTYPE_HANG_BUY = 1;
    public static final int SELLTYPE_HANG_SELL = 2;
    public static final int SELLTYPE_DELEGATE_SELL = 4;
    public static final int SELLTYPE_DELEGATE_BUY = 3;


    public static final String RELOGIN = "relogin";




    public static String IMAGE_URL = "http://47.99.34.238/user/getAvatar?filename=";


    public static String getUserAvatar(String fn) {
        return IMAGE_URL + fn;
    }




}
