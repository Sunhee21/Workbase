package com.csh.lib_framwork.mvp.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;
import com.csh.lib_framwork.mvp.IPresenter;
import com.csh.lib_framwork.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/25
 */
public abstract class BasePresenter<V extends IView> implements IPresenter, LifecycleObserver {

    private static final String TAG = "BasePresenter";
    protected CompositeDisposable mCompositeDisposable;
    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
        onStart();
    }

    @Override
    public void onStart() {
        if (mView != null && mView instanceof LifecycleOwner){
            ((LifecycleOwner) mView).getLifecycle().addObserver(this);
        }
        Log.d(TAG, "onStart: ");
    }

//    /**
//     *  执行于Activity onCreate之后
//     */
//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    public void onCreate(){
//        Log.d("BasePresenter","OnLifecycleEvent onCreate");
//    }

    @Override
    public void onDestroy() {
        unDispose();//解除订阅
        mView = null;
        mCompositeDisposable = null;
        Log.d(TAG, "onDestroy: ");
    }

    /**
     * 执行于Activity 的onDestroy之前
     * @param owner
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner){
        owner.getLifecycle().removeObserver(this);
        Log.d(TAG, "OnLifecycleEvent onDestroy: " + this);
    }


    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);//将所有 Disposable 放入容器集中处理
    }

    public void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();//保证 Activity 结束时取消所有正在执行的订阅
        }
    }
}
