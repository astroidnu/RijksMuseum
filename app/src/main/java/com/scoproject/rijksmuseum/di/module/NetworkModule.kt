package com.scoproject.rijksmuseum.di.module

import com.scoproject.base.di.module.BaseNetworkModule
import com.scoproject.base.di.scope.AppScope
import com.scoproject.rijksmuseum.data.network.RijksService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Module
class NetworkModule : BaseNetworkModule() {
    @Provides
    @AppScope
    fun provideLoginRestService(retrofit: Retrofit): RijksService =
            retrofit.create(RijksService::class.java)
}