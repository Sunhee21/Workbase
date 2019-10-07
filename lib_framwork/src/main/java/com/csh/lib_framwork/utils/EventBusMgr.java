package com.csh.lib_framwork.utils;

import org.greenrobot.eventbus.EventBus;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/8/6
 */
public class EventBusMgr {


    public static void post(Object object) {
        EventBus.getDefault().post(object);
    }


    public static void register(Object object) {
        if (!EventBus.getDefault().isRegistered(object))
            EventBus.getDefault().register(object);
    }

    public static void unregister(Object object) {
        if (EventBus.getDefault().isRegistered(object))
            EventBus.getDefault().unregister(object);
    }


}
