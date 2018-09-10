package com.scoproject.rijksmuseum.features.detailart.di

import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.base.external.scheduler.AppSchedulerProvider
import com.scoproject.rijksmuseum.data.network.RijksService
import com.scoproject.rijksmuseum.data.repository.RijskDataStore
import com.scoproject.rijksmuseum.data.repository.RijskRepository
import com.scoproject.rijksmuseum.features.detailart.presentation.DetailArtActivity
import com.scoproject.rijksmuseum.features.detailart.presentation.DetailArtContract
import com.scoproject.rijksmuseum.features.detailart.presentation.DetailArtPresenter
import com.scoproject.rijksmuseum.features.detailart.usecase.DetailArtInteractor
import com.scoproject.rijksmuseum.features.detailart.usecase.DetailArtUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Module
class DetailArtModule {
    @Provides
    @ActivityScope
    internal fun provideActivity(activity: DetailArtActivity): DetailArtContract.View {
        return activity
    }

    @Provides @ActivityScope
    fun repository(restService: RijksService, appSchedulerProvider: AppSchedulerProvider): RijskRepository
            = RijskDataStore(restService, appSchedulerProvider)

    @Provides @ActivityScope
    fun usecase(repository: RijskRepository): DetailArtUseCase = DetailArtInteractor(repository)


    @Provides @ActivityScope
    internal fun provideListArtPresenter(useCase: DetailArtUseCase,
                                         scheduler: AppSchedulerProvider) =
            DetailArtPresenter(useCase,
                    scheduler)
}