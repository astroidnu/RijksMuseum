package com.scoproject.rijksmuseum.features.profile.di

import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.base.external.scheduler.AppSchedulerProvider
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.profile.domain.ProfileRouter
import com.scoproject.rijksmuseum.features.profile.presentation.ProfileActivity
import com.scoproject.rijksmuseum.features.profile.presentation.ProfileContract
import com.scoproject.rijksmuseum.features.profile.presentation.ProfilePresenter
import com.tunaikumobile.base.data.session.LoginSession
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Module
class ProfileModule {
    @Provides
    @ActivityScope
    internal fun provideActivity(activity: ProfileActivity): ProfileContract.View {
        return activity
    }

    @Provides @ActivityScope
    fun provideRouter(screen: ScreenRouter, activity: ProfileActivity) = ProfileRouter(screen, activity)


    @Provides @ActivityScope
    internal fun provideListArtPresenter(router: ProfileRouter,
                                         loginSession: LoginSession,
                                         scheduler: AppSchedulerProvider) =
            ProfilePresenter(router,
                    loginSession,
                    scheduler)
}