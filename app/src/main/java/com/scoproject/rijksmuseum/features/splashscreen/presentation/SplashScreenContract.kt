package com.scoproject.rijksmuseum.features.splashscreen.presentation

import com.scoproject.base.presentation.ui.view.BaseView

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */

class SplashScreenContract {
    interface View : BaseView {
        fun runSplashScreen(timeout: Long)

    }

    interface UserActionListener {
        fun checkUserLogin()
    }

    interface Router {
        fun goToLoginPage()
        fun goToMainPage()
    }
}