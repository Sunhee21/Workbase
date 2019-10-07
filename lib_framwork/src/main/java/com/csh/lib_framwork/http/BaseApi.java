package com.csh.lib_framwork.http;


import com.csh.lib_framwork.http.gson.GsonConverterFactory;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/24
 */
public abstract class BaseApi<T> {

    private static Retrofit mRetrofit;
    protected T proxy;

    protected BaseApi(Class<T> clazz){
        if (!clazz.isInterface())return;
        if (mRetrofit == null){
            OkHttpClient okHttpClient = ApiConfig.apiConfigImpl.okhttpConfig(new OkHttpClient.Builder())
                    .build();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ApiConfig.apiConfigImpl.getBaseUrl())
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用 Rxjava
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))//使用 Gson
                    .build();
        }
        proxy = mRetrofit.create(clazz);
    }

}
