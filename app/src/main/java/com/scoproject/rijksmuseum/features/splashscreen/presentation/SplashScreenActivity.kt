package com.scoproject.rijksmuseum.features.splashscreen.presentation

import android.os.Bundle
import android.os.Handler
import com.scoproject.base.presentation.ui.activity.BaseActivity
import com.scoproject.rijksmuseum.R
import com.scoproject.rijksmuseum.external.AppConstants.SPLASH_TIMEOUT
import javax.inject.Inject

class SplashScreenActivity : BaseActivity(), SplashScreenContract.View {
    @Inject
    lateinit var mPresenter: SplashScreenPresenter

    override fun getLayoutId(): Int {
       return R.layout.activity_splash_screen
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        runSplashScreen(SPLASH_TIMEOUT.toLong())

    }

    override fun runSplashScreen(timeout: Long) {
        Handler().postDelayed({
            kotlin.run {
                mPresenter.checkUserLogin()
                finish()
            }
        }, timeout)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
