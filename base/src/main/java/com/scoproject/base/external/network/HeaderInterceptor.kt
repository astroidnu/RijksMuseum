package com.scoproject.base.external.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

class HeaderInterceptor : Interceptor {

    /**
     * This method will be checking internet user internet connection
     * Trying and cacthing offline request with cache control
     * */

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = try {
            request.newBuilder()
                    .addHeader("Content-Type", "application/json;charset=utf-8")
                    .build()
        } catch (e: Exception) {
            chain.request().newBuilder()
                    .header("Cache-Control", "application/json;charset=utf-8, public, only-if-cached," +
                            "max-stale=" + 60 * 60 * 24)
                    .build()
        }
        return chain.proceed(request)
    }
}