package com.scoproject.rijksmuseum.features.listart.presentation

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.features.listart.domain.ListArtRouter
import com.tunaikumobile.base.data.session.LoginSession
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtPresenter @Inject constructor(listArtRouter: ListArtRouter,
                                           loginSession: LoginSession,
                                           schedulerProvider: SchedulerProvider) :
        BasePresenter<ListArtContract.View>(schedulerProvider),
        ListArtContract.UserActionListener {

}