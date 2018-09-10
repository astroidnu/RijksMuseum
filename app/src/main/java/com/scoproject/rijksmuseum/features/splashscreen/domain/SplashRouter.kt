package com.scoproject.rijksmuseum.features.splashscreen.domain

import android.app.Activity
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.splashscreen.presentation.SplashScreenContract
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class SplashRouter @Inject constructor(private val screenRouter: ScreenRouter
                                       , private val context: Activity) : SplashScreenContract.Router{
    override fun goToLoginPage() {
        screenRouter.getScreenIntent(context, ScreenRouter.ActivityScreen.LoginScreen)
                ?.run { context.startActivity(this) }
    }

    override fun goToMainPage() {

    }

}