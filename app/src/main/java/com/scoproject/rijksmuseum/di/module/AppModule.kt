package com.scoproject.rijksmuseum.di.module

import android.app.Application
import android.content.Context
import com.scoproject.base.data.database.MyObjectBox
import com.scoproject.base.di.scope.AppScope
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.external.AppContextCoroutineProvider
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.presentation.ScreenRouterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
@Module
class AppModule {
    @Provides @AppScope
    internal fun provideContext(application: Application): Context = application

    @Provides @AppScope
    fun provideScreenRouter(): ScreenRouter = ScreenRouterImpl()

    @Provides @AppScope
    internal fun provideObjectBox(context: Context) =  MyObjectBox.builder().androidContext(context).build()

    @Provides @AppScope
    internal fun provideHelper() = Helper()

    @Provides @AppScope
    internal fun provideAppContextCoroutineProvider() = AppContextCoroutineProvider()
}