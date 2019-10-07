package com.csh.workbase.mvp.presenter

import com.csh.lib_framwork.mvp.base.BasePresenter
import com.csh.workbase.http.UserApi
import com.csh.workbase.mvp.contract.MainContract
import com.csh.workbase.utils.addToLifecycle
import com.csh.workbase.utils.subscribeApi
import timber.log.Timber

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/25
 */
class MainPresenter(mView: MainContract.IMainView) : BasePresenter<MainContract.IMainView>(mView) {


    fun getList() {
        UserApi.instance.getUsers()
            .subscribeApi({

                Timber.d("onSuccess -> $it")
            }, { i: Int, s: String?, any: Any? ->
                Timber.d("onFailure -> $s")
            })
            .addToLifecycle(this)
    }
}


