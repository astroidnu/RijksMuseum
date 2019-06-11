package com.scoproject.rijksmuseum.features.splashscreen.presentation

import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.features.splashscreen.domain.SplashRouter
import com.tunaikumobile.base.data.session.LoginSession
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class SplashScreenPresenter @Inject constructor(val loginSession: LoginSession,
                                                val splashRouter: SplashRouter) :
        BasePresenter<SplashScreenContract.View>(), SplashScreenContract.UserActionListener {

    /**
     * Checking user login state
     * */

    override fun checkUserLogin() {
        if (loginSession.getUsername().isNotEmpty()) {
            splashRouter.goToMainPage()
        } else {
            splashRouter.goToLoginPage()
        }
    }

}