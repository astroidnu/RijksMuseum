package com.scoproject.rijksmuseum.features.login.presentation

import android.os.Bundle
import com.scoproject.base.presentation.ui.activity.BaseActivity
import com.scoproject.rijksmuseum.R
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

class LoginActivity : BaseActivity(), LoginContract.View {
    @Inject
    lateinit var mPresenter: LoginPresenter

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }


}