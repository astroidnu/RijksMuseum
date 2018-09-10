package com.scoproject.rijksmuseum.features.registration.presentation

import android.os.Bundle
import com.scoproject.base.external.extensions.showToast
import com.scoproject.base.presentation.ui.activity.BaseActivity
import com.scoproject.rijksmuseum.R
import kotlinx.android.synthetic.main.activity_registration.*
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */

class RegistrationActivity : BaseActivity(), RegistrationContract.View {
    @Inject
    lateinit var mPresenter: RegistrationPresenter

    override fun getLayoutId(): Int {
        return R.layout.activity_registration
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupUIListener()
    }

    override fun setupUIListener() {
        btnRegistration.setOnClickListener {
            val userName = etUsername.text.toString()
            val password = etPassword.text.toString()
            val checkedTermAndCondition = cbTermsAndCondition.isChecked
            mPresenter.doRegistration(userName, password, checkedTermAndCondition)
        }
    }

    override fun showError(msg: String) {
        showToast(msg)
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}