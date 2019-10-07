package com.csh.workbase.mvp.ui

import android.os.Bundle
import com.csh.lib_framwork.mvp.base.BaseActivity
import com.csh.workbase.R
import com.csh.workbase.mvp.contract.MainContract
import com.csh.workbase.mvp.presenter.MainPresenter

class MainActivity : BaseActivity(),MainContract.IMainView {
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun obtainPresenter()= arrayOf(MainPresenter(this))

    override fun initViewListener() {

    }

    override fun render() {

    }


    override fun initData(savedInstanceState: Bundle?) {

    }
}
