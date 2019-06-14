package com.scoproject.rijksmuseum.features.detailart.presentation

import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.data.network.NetworkError
import com.scoproject.rijksmuseum.external.AppContextCoroutineProvider
import com.scoproject.rijksmuseum.features.detailart.usecase.DetailArtUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class DetailArtPresenter @Inject constructor(private val detailArtUseCase: DetailArtUseCase,
                                             private val appContextCoroutineProvider: AppContextCoroutineProvider) :
        BasePresenter<DetailArtContract.View>(),
        DetailArtContract.UserActionListener {
    override fun getDetailCollection(objectNumber: String) {
        GlobalScope.launch(appContextCoroutineProvider.uiDispatcher()) {
            try {
                view?.showLoading()
                val response = detailArtUseCase.getDetailCollection(objectNumber)
                view?.hideLoading()
                view?.setupContent(response.imageUrl,
                        response.description)
            } catch (e: Throwable) {
                view?.hideLoading()
                val err = NetworkError(err = e).getErrorMessage()
                view?.showError(err)
            }
        }
    }

}