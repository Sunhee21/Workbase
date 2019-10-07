package com.csh.workbase.utils

import android.annotation.SuppressLint
import com.csh.workbase.http.common.ApiObserver
import com.csh.workbase.http.common.BaseBean
import com.csh.lib_framwork.mvp.IView
import com.csh.lib_framwork.mvp.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/**
 * @intro 扩展类
 * @author sunhee
 * @date 2019/7/25
 */

fun <V:IView>Disposable.addToLifecycle(p : BasePresenter<V>){
    p.addDispose(this)
}


@SuppressLint("CheckResult")
fun <T:BaseBean>Observable<T>.subscribeApi(onSuc:(T) -> Unit, onFail:((code: Int, msg: String?, objects: Any?) -> Unit))=
    this.subscribeWith(object : ApiObserver<T>(){
        override fun onSuccess(t: T) {
            onSuc.invoke(t)
        }

        override fun onFailure(code: Int, msg: String?, objects: Any?) {
            super.onFailure(code, msg, objects)//如果不想使用全局的错误code处理，不能使用此扩展
            onFail.invoke(code, msg, objects)
        }

    })

