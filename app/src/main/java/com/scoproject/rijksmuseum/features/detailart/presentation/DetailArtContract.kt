package com.scoproject.rijksmuseum.features.detailart.presentation

import com.scoproject.base.presentation.ui.view.BaseView

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class DetailArtContract {
    interface View : BaseView {
        fun setupContent(imageUrl : String?, artDesc: String?)
        fun showError(msg: String)
        fun showLoading()
        fun hideLoading()
    }

    interface UserActionListener {
        fun getDetailCollection(objectNumber: String)
    }

    interface Router {

    }
}