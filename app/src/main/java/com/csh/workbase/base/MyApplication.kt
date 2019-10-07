package com.csh.workbase.base

import android.app.Application
import com.csh.lib_framwork.http.ApiConfig
import com.csh.lib_framwork.utils.Utils
import com.csh.workbase.BuildConfig
import timber.log.Timber

/**
 * @intro
 * @author chenshanghui
 * @date 2019/7/25
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        ApiConfig.init(ApiConfigImpl())
    }

}