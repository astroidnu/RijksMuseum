package com.scoproject.rijksmuseum

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.scoproject.base.data.model.UserModel
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.registration.domain.RegistrationRouter
import com.scoproject.rijksmuseum.features.registration.presentation.RegistrationContract
import com.scoproject.rijksmuseum.features.registration.presentation.RegistrationPresenter
import com.tunaikumobile.base.data.session.LoginSession
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */

class RegistrationPresenterTest {
    private lateinit var mRegistrationPresenter: RegistrationPresenter
    private val mView: RegistrationContract.View = mock()
    private lateinit var mHelper: Helper
    private val mLoginSession: LoginSession = mock()
    private val mUserModel: UserModel = mock()
    private val mLoginRouter: RegistrationRouter = mock()

    @Before
    fun setUp() {
        mHelper = Helper()
        mRegistrationPresenter = RegistrationPresenter(mUserModel,
                mLoginRouter,
                mHelper,
                mLoginSession)
        mRegistrationPresenter.attachView(mView)
    }

    @Test
    fun doLoginShouldReturnUserNameNotBeEmpty() {
        mRegistrationPresenter.doRegistration("", "", false)
        verify(mView).showError("Username should not be empty")
    }

    @Test
    fun doLoginShouldReturnPasswordNotBeEmpty() {
        mRegistrationPresenter.doRegistration("asasa", "", true)
        verify(mView).showError("Password should not be empty")
    }


    @After
    fun tearDown() {
        mRegistrationPresenter.detachView()
    }
}
