package com.scoproject.rijksmuseum.features.splashscreen.di

import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.base.external.scheduler.AppSchedulerProvider
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.splashscreen.domain.SplashRouter
import com.scoproject.rijksmuseum.features.splashscreen.presentation.SplashScreenActivity
import com.scoproject.rijksmuseum.features.splashscreen.presentation.SplashScreenContract
import com.scoproject.rijksmuseum.features.splashscreen.presentation.SplashScreenPresenter
import com.tunaikumobile.base.data.session.LoginSession
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Module
class SplashScreenModule {
    @Provides
    @ActivityScope
    internal fun provideActivity(activity: SplashScreenActivity): SplashScreenContract.View {
        return activity
    }

    @Provides @ActivityScope
    fun provideRouter(screen: ScreenRouter, activity: SplashScreenActivity) = SplashRouter(screen, activity)

    @Provides
    @ActivityScope
    internal fun providePresenter(loginSession: LoginSession,
                                  splashRouter: SplashRouter,
                                  scheduler: AppSchedulerProvider) =
            SplashScreenPresenter(loginSession,
                    splashRouter,
                    scheduler)
}