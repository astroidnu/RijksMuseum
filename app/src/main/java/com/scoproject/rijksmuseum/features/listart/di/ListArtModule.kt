package com.scoproject.rijksmuseum.features.listart.di

import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.base.external.scheduler.AppSchedulerProvider
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.listart.domain.ListArtRouter
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtActivity
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtContract
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtPresenter
import com.tunaikumobile.base.data.session.LoginSession
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Module
class ListArtModule {
    @Provides
    @ActivityScope
    internal fun provideActivity(activity: ListArtActivity): ListArtContract.View {
        return activity
    }

    @Provides @ActivityScope
    fun provideRouter(screen: ScreenRouter, activity: ListArtActivity) = ListArtRouter(screen, activity)


    @Provides @ActivityScope
    internal fun provideListArtPresenter(router: ListArtRouter,
                                         loginSession: LoginSession,
                                         scheduler: AppSchedulerProvider) =
            ListArtPresenter(router,
                    loginSession,
                    scheduler)
}