package com.csh.workbase.mvp.ui

import android.os.Bundle
import com.csh.lib_framwork.mvp.IPresenter
import com.csh.lib_framwork.mvp.base.BaseActivity
import com.csh.workbase.R
import kotlinx.android.synthetic.main.activity_t1.*
import org.jetbrains.anko.startActivity

class T1Activity : BaseActivity() {
    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun obtainPresenter() = null


    override fun initData(savedInstanceState: Bundle?) {
        button3.setOnClickListener {
            startActivity<T2Activity>()
        }
    }

    override fun getLayoutId(): Int =R.layout.activity_t1


}
