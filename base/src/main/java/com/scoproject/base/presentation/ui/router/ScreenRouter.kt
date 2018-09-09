package com.scoproject.base.presentation.ui.router

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
interface ScreenRouter {
    sealed class ActivityScreen {
        object SplashScreen : ActivityScreen()
    }
}