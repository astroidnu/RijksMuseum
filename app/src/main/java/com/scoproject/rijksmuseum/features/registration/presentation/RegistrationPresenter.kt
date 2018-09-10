package com.scoproject.rijksmuseum.features.registration.presentation

import com.scoproject.base.data.model.UserModel
import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.registration.domain.RegistrationRouter
import com.tunaikumobile.base.data.session.LoginSession
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class RegistrationPresenter @Inject constructor(private val userModel: UserModel,
                                                private val router: RegistrationRouter,
                                                private val helper : Helper,
                                                private val loginSession: LoginSession,
                                                schedulerProvider: SchedulerProvider) :
        BasePresenter<RegistrationContract.View>(schedulerProvider), RegistrationContract.UserActionListener {
    override fun doRegistration(userName: String, password: String, isCheckedTermAndCondition: Boolean) {
        if(!helper.isUsenameValid(userName)) {
            view?.showError("Username should not be empty")
        }else if(!helper.isPasswordValid(password)) {
            view?.showError("Password should not be empty")
        }else if(!helper.isUsenameValid(userName) && !helper.isPasswordValid(userName)) {
            view?.showError("Username and Password should not be empty")
        }else if(helper.isUsenameValid(userName) && helper.isPasswordValid(userName) && !isCheckedTermAndCondition) {
            view?.showError("Checkbox should be check")
        }else {
            userModel.saveUser(userName,password)
            loginSession.saveUsername(userName)
            router.goToLoginPage()
        }
    }
}