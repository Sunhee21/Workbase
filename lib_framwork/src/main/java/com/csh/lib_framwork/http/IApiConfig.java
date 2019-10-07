package com.csh.lib_framwork.http;

import okhttp3.OkHttpClient;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/8/5
 */
public interface IApiConfig {


    String getBaseUrl();

    int getSuccessCode();

    OkHttpClient.Builder okhttpConfig(OkHttpClient.Builder builder);

}
