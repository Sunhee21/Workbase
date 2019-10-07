package com.csh.lib_framwork.http.interceptor;

import okhttp3.MediaType;
import okhttp3.Request;
import timber.log.Timber;

import java.util.List;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/25
 */
public class DefaultFormatPrinter implements FormatPrinter {
    @Override
    public void printJsonRequest(Request request, String bodyString) {
        Timber.i("printJsonRequest:" + "requestUrl: <" + request.url() + ">\n--Header:" + request.headers().toString() + "\n--param: " + bodyString);
    }

    @Override
    public void printFileRequest(Request request) {
        Timber.i("printFileRequest:" + "requestUrl: <" + request.url() + ">\n--Header:" + request.headers().toString() + "\n--param: " + request.body().toString());
    }

    @Override
    public void printJsonResponse(long chainMs, boolean isSuccessful, int code, String headers, MediaType contentType, String bodyString, List<String> segments, String message, String responseUrl) {
        Timber.i("printJsonResponse:" + "responseUrl: <" + responseUrl + ">\n--Header:" + headers + "\n--result: " + bodyString);
    }

    @Override
    public void printFileResponse(long chainMs, boolean isSuccessful, int code, String headers, List<String> segments, String message, String responseUrl) {
        Timber.i("printFileResponse:" + responseUrl);
    }
}
