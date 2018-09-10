package com.scoproject.rijksmuseum

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.scoproject.base.data.model.UserModel
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.login.domain.LoginRouter
import com.scoproject.rijksmuseum.features.login.presentation.LoginContract
import com.scoproject.rijksmuseum.features.login.presentation.LoginPresenter
import com.scoproject.rijksmuseum.util.TestSchedulerProvider
import com.tunaikumobile.base.data.session.LoginSession
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */

class LoginPresenterTest {
    private lateinit var mLoginPresenter : LoginPresenter
    private lateinit var mTestScheduler: TestScheduler
    private val mView: LoginContract.View = mock()
    private lateinit var mHelper : Helper
    private val mLoginSession: LoginSession = mock()
    private val mUserModel: UserModel = mock()
    private val mLoginRouter: LoginRouter = mock()

    @Before
    fun setUp() {
        mHelper = Helper()
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        mLoginPresenter = LoginPresenter(mUserModel,
                mLoginRouter,
                mHelper,
                mLoginSession,
                testSchedulerProvider)
        mLoginPresenter.attachView(mView)
    }

    @Test
    fun doLoginShouldReturnUserNameNotBeEmpty() {
        mLoginPresenter.doLogin("","")
        verify(mView).showError("Username should not be empty")
    }

    @Test
    fun doLoginShouldReturnPasswordNotBeEmpty() {
        mLoginPresenter.doLogin("asasa","")
        verify(mView).showError("Password should not be empty")
    }


    @After
    fun tearDown(){
        mLoginPresenter.detachView()
    }
}
