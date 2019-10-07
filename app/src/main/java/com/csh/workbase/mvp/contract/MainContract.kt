package com.csh.workbase.mvp.contract

import com.csh.lib_framwork.mvp.IModel
import com.csh.lib_framwork.mvp.IView

/**
 * @intro
 * @author chenshanghui
 * @date 2019/7/25
 */
class MainContract{

    interface IMainModel :IModel

    interface IMainView :IView{
        fun render()
    }



}