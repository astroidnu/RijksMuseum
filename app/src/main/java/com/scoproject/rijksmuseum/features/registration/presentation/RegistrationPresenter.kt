package com.scoproject.rijksmuseum.features.registration.presentation

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.features.registration.domain.RegistrationRouter
import com.tunaikumobile.base.data.session.LoginSession
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class RegistrationPresenter @Inject constructor(private val router: RegistrationRouter,
                                                private val loginSession: LoginSession,
                                                schedulerProvider: SchedulerProvider) :
        BasePresenter<RegistrationContract.View>(schedulerProvider), RegistrationContract.UserActionListener {

    override fun isUsenameValid(username: String): Boolean {
        return username.isNotEmpty()
    }

    override fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    override fun doRegistration(userName: String, password: String, isCheckedTermAndCondition: Boolean) {
        if(!isUsenameValid(userName)) {
            view?.showError("Username should not be empty")
        }else if(!isPasswordValid(password)) {
            view?.showError("Password should not be empty")
        }else if(!isUsenameValid(userName) && !isPasswordValid(userName)) {
            view?.showError("Username and Password should not be empty")
        }else if(isUsenameValid(userName) && isPasswordValid(userName) && !isCheckedTermAndCondition) {
            view?.showError("Checkbox should be check")
        }else {
            view?.showError("Do Registration")
        }
    }

    override fun saveUserData(userName: String, password: String) {

    }

}