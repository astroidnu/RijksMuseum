package com.scoproject.rijksmuseum.features.login.presentation

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
class LoginPresenter @Inject constructor(schedulerProvider: SchedulerProvider):
        BasePresenter<LoginContract.View>(schedulerProvider),
        LoginContract.UserActionListener {

}