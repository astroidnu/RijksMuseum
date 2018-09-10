package com.scoproject.rijksmuseum.features.listart.presentation

import com.scoproject.base.presentation.ui.view.BaseView
import com.scoproject.rijksmuseum.data.response.ArtObject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtContract {
    interface View : BaseView {
        fun setupAdapter(data : ArtObject.Response)
    }

    interface UserActionListener {
        fun getCollections()
    }

    interface Router {

    }
}