package com.scoproject.rijksmuseum.external

import android.arch.lifecycle.ViewModel
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.base.presentation.ui.view.BaseView


/**
 * Created by ibnumuzzakkir on 2019-06-10.
 * Mobile Engineer
 */

class BaseViewModel<V : BaseView, P : BasePresenter<V>> : ViewModel() {

    private var presenter: P? = null

    internal fun setPresenter(presenter: P) {
        if (this.presenter == null) {
            this.presenter = presenter
        }
    }

    internal fun getPresenter(): P? {
        return this.presenter
    }

    override fun onCleared() {
        super.onCleared()
        presenter = null
    }
}