package com.scoproject.rijksmuseum.features.detailart.presentation

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.features.detailart.usecase.DetailArtUseCase
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class DetailArtPresenter @Inject constructor(private val useCase: DetailArtUseCase,
                                             schedulerProvider: SchedulerProvider):
        BasePresenter<DetailArtContract.View>(schedulerProvider),
        DetailArtContract.UserActionListener {
    override fun getDetailCollection(objectNumber: String) {
        view?.showLoading()
        addDisposable(useCase.getDetailCollection(objectNumber)
                .subscribe({ response ->
                    view?.hideLoading()
                    view?.setupContent(response.artObject?.webImage?.url,
                            response.artObject?.label?.description)
                }, { err ->
                    view?.hideLoading()
                    view?.showError(err.message.toString())
                }))
    }

}