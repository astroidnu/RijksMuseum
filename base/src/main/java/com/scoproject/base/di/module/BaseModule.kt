package com.scoproject.base.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.scoproject.base.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

@Module
abstract class BaseModule {
    @Provides
    @AppScope
    fun provideContext(application: Application): Context = application

    @Provides
    @AppScope
    fun gson() = Gson()
}