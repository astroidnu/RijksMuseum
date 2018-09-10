package com.scoproject.base.presentation.ui.router

import android.content.Context
import android.content.Intent

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
interface ScreenRouter {
    sealed class ActivityScreen {
        object SplashScreen : ActivityScreen()
        object LoginScreen : ActivityScreen()
        object RegistrationScreen : ActivityScreen()
        object DetailCollectionScreen : ActivityScreen()
    }

    fun getScreenIntent(context: Context, screen: ActivityScreen): Intent?
}