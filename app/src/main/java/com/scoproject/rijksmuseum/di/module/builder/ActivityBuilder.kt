package com.scoproject.rijksmuseum.di.module.builder

import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.rijksmuseum.features.login.di.LoginModule
import com.scoproject.rijksmuseum.features.login.presentation.LoginActivity
import com.scoproject.rijksmuseum.features.splashscreen.di.SplashScreenModule
import com.scoproject.rijksmuseum.features.splashscreen.presentation.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(SplashScreenModule::class)])
    internal abstract fun bindSplashScreen(): SplashScreenActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(LoginModule::class)])
    internal abstract fun bindLoginActivity(): LoginActivity
}