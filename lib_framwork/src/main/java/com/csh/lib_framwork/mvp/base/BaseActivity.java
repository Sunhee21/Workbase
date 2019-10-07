package com.csh.lib_framwork.mvp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.csh.lib_framwork.mvp.IPresenter;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/25
 */
public abstract class BaseActivity extends AppCompatActivity {


    protected IPresenter[] mPresenter;

    protected Context mContext;

    protected abstract IPresenter[] obtainPresenter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mContext = this;
        mPresenter = obtainPresenter();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView(savedInstanceState);
        initData(savedInstanceState);
        initViewListener();
    }

    protected abstract void initView(Bundle savedInstanceState);


    protected abstract void initData(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    protected void initViewListener() {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            for (IPresenter ip : mPresenter) {
                ip.onDestroy();
            }
            mPresenter = null;
        }
    }



    private ProgressDialog mProgressDialog;

    protected void showLoading() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
        }
        if (!mProgressDialog.isShowing())
            mProgressDialog.show();
    }


    protected void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}
