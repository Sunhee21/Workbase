package com.csh.lib_framwork.http;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/25
 */
public class ApiConfig {

    public static IApiConfig apiConfigImpl = null;

    public static void init(IApiConfig impl) {
        apiConfigImpl = impl;
    }


}
