package com.scoproject.rijksmuseum.features.login.presentation

import android.os.Bundle
import com.scoproject.base.external.extensions.showToast
import com.scoproject.base.presentation.ui.activity.BaseActivity
import com.scoproject.rijksmuseum.R
import com.scoproject.rijksmuseum.features.login.domain.LoginRouter
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

class LoginActivity : BaseActivity(), LoginContract.View {
    @Inject
    lateinit var mPresenter: LoginPresenter

    @Inject
    lateinit var router: LoginRouter

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        setupUIListener()
    }

    override fun setupUIListener() {
        btnLogin.setOnClickListener {
            val userName = etUsername.text.toString()
            val password= etPassword.text.toString()
            mPresenter.doLogin(userName, password)
        }

        llRegister.setOnClickListener { router.goToRegistrationPage() }
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }


}