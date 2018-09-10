package com.scoproject.rijksmuseum.features.login.presentation

import com.scoproject.base.presentation.ui.view.BaseView

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

class LoginContract {
    interface View : BaseView {
        fun setupUIListener()
        fun showError(msg :String)
    }

    interface UserActionListener {
        fun doLogin(userName: String, password: String)
        fun isUserRegistered(userName: String, password: String) : Boolean
    }

    interface Router {
        fun goToMainPage()
        fun goToRegistrationPage()
    }
}