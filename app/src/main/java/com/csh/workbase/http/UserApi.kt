package com.csh.workbase.http

import com.csh.lib_framwork.http.BaseApi
import com.csh.workbase.http.common.BaseJson
import com.csh.lib_framwork.utils.RxUtils
import io.reactivex.Observable

/**
 * @author sunhee
 * @intro
 * @date 2019/7/25
 */
class UserApi:BaseApi<UserService>(UserService::class.java),
    UserService {


    companion object{
        val instance: UserApi by lazy {
            UserApi()
        }
    }


    override fun getUsers(): Observable<BaseJson<List<String>>> {
        return proxy.getUsers().compose(RxUtils.applySchedulers())
    }

}
