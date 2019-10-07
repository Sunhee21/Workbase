package com.csh.workbase.mvp.ui

import android.os.Bundle
import com.csh.lib_framwork.mvp.IPresenter
import com.csh.lib_framwork.mvp.base.BaseActivity
import com.csh.lib_framwork.utils.ActivityUtils
import com.csh.workbase.R
import kotlinx.android.synthetic.main.activity_t2.*

class T2Activity : BaseActivity() {
    override fun obtainPresenter() = null

    override fun initView(savedInstanceState: Bundle?) {
    }


    override fun initData(savedInstanceState: Bundle?) {
        button2.setOnClickListener {
            ActivityUtils.finishAllActivities()
        }
    }

    override fun getLayoutId(): Int =R.layout.activity_t2


}
