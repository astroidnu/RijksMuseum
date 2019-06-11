package com.scoproject.rijksmuseum.features.listart.di

import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.data.network.RijksService
import com.scoproject.rijksmuseum.features.listart.domain.ListArtRouter
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtActivity
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtContract
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtPresenter
import com.scoproject.rijksmuseum.features.listart.usecase.ListArtInteractor
import com.scoproject.rijksmuseum.features.listart.usecase.ListArtUseCase
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

    @Provides
    @ActivityScope
    fun provideRouter(screen: ScreenRouter, activity: ListArtActivity) = ListArtRouter(screen, activity)

    @Provides
    @ActivityScope
    fun usecase(rijsService: RijksService): ListArtUseCase = ListArtInteractor(rijsService)


    @Provides
    @ActivityScope
    internal fun provideListArtPresenter(listArtUseCase: ListArtUseCase) =
            ListArtPresenter(listArtUseCase)
}