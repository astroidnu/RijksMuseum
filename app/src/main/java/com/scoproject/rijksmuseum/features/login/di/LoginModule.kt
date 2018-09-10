package com.scoproject.rijksmuseum.features.login.di

import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.base.external.scheduler.AppSchedulerProvider
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.login.domain.LoginRouter
import com.scoproject.rijksmuseum.features.login.presentation.LoginActivity
import com.scoproject.rijksmuseum.features.login.presentation.LoginContract
import com.scoproject.rijksmuseum.features.login.presentation.LoginPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Module
class LoginModule {
    @Provides
    @ActivityScope
    internal fun provideActivity(loginActivity: LoginActivity): LoginContract.View {
        return loginActivity
    }

    @Provides @ActivityScope
    fun provideRouter(screen: ScreenRouter, activity: LoginActivity) = LoginRouter(screen, activity)


    @Provides @ActivityScope
    internal fun provideLoginPresenter(scheduler: AppSchedulerProvider) = LoginPresenter(scheduler)
}