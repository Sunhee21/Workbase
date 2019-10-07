package com.csh.lib_framwork.http;

import retrofit2.Call;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/24
 */
public class CommonApi extends BaseApi<CommonService> implements CommonService{

    private static final CommonApi instance = new CommonApi();

    public static CommonApi getInstance(){
        return instance;
    }

    private CommonApi() {
        super(CommonService.class);
    }


    public CommonService getProxy(){
        return proxy;
    }


    @Override
    public Call getList() {
        return proxy.getList();
    }
}
