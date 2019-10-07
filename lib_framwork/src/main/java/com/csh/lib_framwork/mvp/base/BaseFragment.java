package com.csh.lib_framwork.mvp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.csh.lib_framwork.mvp.IPresenter;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/25
 */
public abstract class BaseFragment extends Fragment {

    protected IPresenter[] mPresenter;

    protected Context mContext;

    protected abstract IPresenter[] obtainPresenter();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = obtainPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        initView(savedInstanceState);
        initData(savedInstanceState);
        initViewListener();
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    protected abstract void initData(Bundle savedInstanceState);

    protected void initViewListener() {
    }

    @Override
    public void onDestroy() {
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
            mProgressDialog = new ProgressDialog(getActivity());
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
