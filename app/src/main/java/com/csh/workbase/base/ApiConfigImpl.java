package com.csh.workbase.base;


import com.csh.lib_framwork.http.IApiConfig;
import com.csh.lib_framwork.http.interceptor.RequestInterceptor;
import com.csh.workbase.http.common.ApiConstants;
import com.csh.workbase.http.common.CommonInterceptor;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/8/5
 */
public class ApiConfigImpl implements IApiConfig {



    @Override
    public String getBaseUrl() {
        return "http://47.99.34.238";
    }

    @Override
    public int getSuccessCode() {
        return ApiConstants.RESULT_SUCCESS;
    }


    @Override
    public OkHttpClient.Builder okhttpConfig(OkHttpClient.Builder builder) {
        return builder.writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addNetworkInterceptor(new RequestInterceptor())
                .addInterceptor(new CommonInterceptor());//日志 公共参数
    }


}
