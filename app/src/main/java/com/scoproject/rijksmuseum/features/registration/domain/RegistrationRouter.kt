package com.scoproject.rijksmuseum.features.registration.domain

import android.app.Activity
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.registration.presentation.RegistrationContract
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class RegistrationRouter @Inject constructor(val screenRouter: ScreenRouter
                                      , val context: Activity) : RegistrationContract.Router{

    override fun goToLoginPage() {
        screenRouter.getScreenIntent(context, ScreenRouter.ActivityScreen.LoginScreen)
                ?.run { context.startActivity(this) }
    }


}