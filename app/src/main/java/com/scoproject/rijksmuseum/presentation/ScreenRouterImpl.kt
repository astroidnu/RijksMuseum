package com.scoproject.rijksmuseum.presentation

import android.content.Context
import android.content.Intent
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.detailart.presentation.DetailArtActivity
import com.scoproject.rijksmuseum.features.login.presentation.LoginActivity
import com.scoproject.rijksmuseum.features.registration.presentation.RegistrationActivity
import com.scoproject.rijksmuseum.features.splashscreen.presentation.SplashScreenActivity

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */

class ScreenRouterImpl : ScreenRouter {

    override fun getScreenIntent(context: Context, screen: ScreenRouter.ActivityScreen): Intent? {
        val c: Class<*>? = when (screen) {
            /**
             * General Section List Page
             */
            ScreenRouter.ActivityScreen.SplashScreen -> SplashScreenActivity::class.java
            ScreenRouter.ActivityScreen.LoginScreen -> LoginActivity::class.java
            ScreenRouter.ActivityScreen.RegistrationScreen -> RegistrationActivity::class.java
            ScreenRouter.ActivityScreen.DetailCollectionScreen -> DetailArtActivity::class.java
            else -> null
        }
        return if (c == null) null else Intent(context, c)
    }

}