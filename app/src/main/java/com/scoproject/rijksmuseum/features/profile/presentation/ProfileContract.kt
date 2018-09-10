package com.scoproject.rijksmuseum.features.profile.presentation

import com.scoproject.base.presentation.ui.view.BaseView

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ProfileContract {
    interface View : BaseView {
        fun setupUIContent()
        fun setupUIListener()
    }

    interface UserActionListener {
        fun logout()
    }

    interface Router {
        fun goToLoginPage()
    }
}