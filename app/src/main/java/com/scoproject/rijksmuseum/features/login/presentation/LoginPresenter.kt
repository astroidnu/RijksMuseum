package com.scoproject.rijksmuseum.features.login.presentation

import com.scoproject.base.data.model.UserModel
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.login.domain.LoginRouter
import com.tunaikumobile.base.data.session.LoginSession
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
class LoginPresenter @Inject constructor(private val userModel: UserModel,
                                         private val loginRouter: LoginRouter,
                                         private val helper: Helper,
                                         private val loginSession: LoginSession) :
        BasePresenter<LoginContract.View>(),
        LoginContract.UserActionListener {
    override fun doLogin(userName: String, password: String) {
        if (!helper.isUsenameValid(userName)) {
            view?.showError("Username should not be empty")
        } else if (!helper.isPasswordValid(password)) {
            view?.showError("Password should not be empty")
        } else if (!helper.isUsenameValid(userName) && !helper.isPasswordValid(password)) {
            view?.showError("Username and password should not be empty")
        } else {
            if (isUserRegistered(userName, password)) {
                loginSession.saveUsername(userName)
                loginRouter.goToMainPage()
            } else {
                view?.showError("Authentication Failed !")
            }
        }
    }

    override fun isUserRegistered(userName: String, password: String): Boolean {
        return userModel.getUserData(userName, password) != null

    }
}