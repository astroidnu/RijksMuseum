package com.scoproject.base.presentation.ui.view

import com.scoproject.base.presentation.ui.presenter.BasePresenter

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

interface BaseView{
    fun setPresenter(presenter: BasePresenter<*>)
}
