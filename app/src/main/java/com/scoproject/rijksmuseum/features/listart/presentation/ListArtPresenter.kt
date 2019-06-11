package com.scoproject.rijksmuseum.features.listart.presentation

import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.data.network.NetworkError
import com.scoproject.rijksmuseum.data.response.ArtObject
import com.scoproject.rijksmuseum.features.listart.usecase.ListArtUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtPresenter @Inject constructor(private val listArtUseCase: ListArtUseCase) :
        BasePresenter<ListArtContract.View>(),
        ListArtContract.UserActionListener {
    lateinit var data: ArtObject.Response

    override fun getCollections() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                view?.showLoading()
                data = listArtUseCase.getCollectionsAsync()
                view?.setupAdapter(data)
                view?.hideLoading()
            } catch (e: Throwable) {
                view?.hideLoading()
                val err = NetworkError(err = e).getErrorMessage()
                view?.showError(err)
            }
        }
    }
}