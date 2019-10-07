package com.csh.workbase.http.common;

import android.net.ParseException;
import android.widget.Toast;
import com.csh.workbase.http.common.BaseBean;
import com.csh.lib_framwork.http.gson.DataResultException;
import com.csh.lib_framwork.utils.Utils;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import io.reactivex.observers.DisposableObserver;
import org.json.JSONException;
import retrofit2.HttpException;
import timber.log.Timber;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * rx 请求结果处理 包含异常处理
 *
 * @author chenshanghui
 * @intro
 * @date 2019/7/26
 */
public abstract class ApiObserver<T extends BaseBean> extends DisposableObserver<T> {

    public void onFailure(int code, String msg, Object objects){//这里也可以写一些全局的非成功code处理

    }

    public abstract void onSuccess(T t);

    @Override
    public void onNext(T t) {//因为GsonResponseBodyConverter里过滤了,这里只有成功的code才会走这
        onSuccess(t);
    }


    @Override
    public void onComplete() {

    }


    @Override
    public void onError(Throwable t) {
        Timber.tag("Catch-Error").w(t.getMessage());
        //这里不光是只能打印错误,还可以根据不同的错误作出不同的逻辑处理
        String msg = "未知错误";
        if (t instanceof UnknownHostException || t instanceof ConnectException) {
            msg = "网络不可用";
        } else if (t instanceof SocketTimeoutException) {
            msg = "请求网络超时";
        } else if (t instanceof HttpException) {
            msg = dealError((HttpException) t);
        } else if (t instanceof JsonParseException || t instanceof ParseException || t instanceof JSONException || t instanceof JsonIOException) {
            msg = "数据解析错误";
        } else if (t instanceof DataResultException) {//所有其他非成功的code都走这
            DataResultException d = (DataResultException) t;
            onFailure(d.getCode(), d.getMsg(), d.getObj());
            return;
        }
        Toast.makeText(Utils.getApp(), msg, Toast.LENGTH_SHORT).show();
    }

    private String dealError(HttpException httpException) {
        String msg;
        if (httpException.code() == 500) {
            msg = "服务器发生错误";
        } else if (httpException.code() == 404) {
            msg = "请求地址不存在";
        } else if (httpException.code() == 403) {
            msg = "请求被服务器拒绝";
        } else if (httpException.code() == 307) {
            msg = "请求被重定向到其他页面";
        } else {
            msg = httpException.message();
        }
        return msg;
    }
}
