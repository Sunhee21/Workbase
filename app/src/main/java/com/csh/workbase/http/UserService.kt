package com.csh.workbase.http

import com.csh.workbase.http.common.BaseJson
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @intro
 * @author sunhee
 * @date 2019/7/25
 */

interface UserService{

    @GET("/getDemo")
    fun getUsers(): Observable<BaseJson<List<String>>>

    companion object {
        const val HEADER_API_VERSION = "Accept: application/vnd.github.v3+json"
    }

}