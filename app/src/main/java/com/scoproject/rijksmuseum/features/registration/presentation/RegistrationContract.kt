package com.scoproject.rijksmuseum.features.registration.presentation

import com.scoproject.base.presentation.ui.view.BaseView

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class RegistrationContract {
    interface View : BaseView {
        fun setupUIListener()
        fun showError(msg: String)
    }

    interface UserActionListener {
        fun doRegistration(userName : String, password: String,isCheckedTermAndCondition: Boolean)
    }

    interface Router {
        fun goToLoginPage()
    }
}