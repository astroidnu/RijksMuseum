package com.scoproject.rijksmuseum.features.listart.presentation

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.features.listart.usecase.ListArtUseCase
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtPresenter @Inject constructor(private val useCase: ListArtUseCase,
                                           schedulerProvider: SchedulerProvider) :
        BasePresenter<ListArtContract.View>(schedulerProvider),
        ListArtContract.UserActionListener {

    override fun getCollections() {
        view?.showLoading()
        addDisposable(useCase.getCollections()
                .subscribe({ response ->
                    view?.hideLoading()
                    view?.setupAdapter(response)
                }, { err ->
                    view?.hideLoading()
                    view?.showError(err.message.toString())
                }))
    }

}