package com.scoproject.rijksmuseum.features.profile.presentation

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.features.profile.domain.ProfileRouter
import com.tunaikumobile.base.data.session.LoginSession
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ProfilePresenter @Inject constructor(router: ProfileRouter,
                                           loginSession: LoginSession,
                                           schedulerProvider: SchedulerProvider) :
        BasePresenter<ProfileContract.View>(schedulerProvider),
        ProfileContract.UserActionListener {

}