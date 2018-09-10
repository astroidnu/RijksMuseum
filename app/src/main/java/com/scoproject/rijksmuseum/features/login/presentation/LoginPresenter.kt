package com.scoproject.rijksmuseum.features.login.presentation

import com.scoproject.base.data.model.UserModel
import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.rijksmuseum.features.login.domain.LoginRouter
import com.tunaikumobile.base.data.session.LoginSession
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
class LoginPresenter @Inject constructor(private val userModel: UserModel,
                                         private val loginRouter: LoginRouter,
                                         private val loginSession: LoginSession,
                                         schedulerProvider: SchedulerProvider):
        BasePresenter<LoginContract.View>(schedulerProvider),
        LoginContract.UserActionListener {
    override fun doLogin(userName: String, password: String) {
        if(userName.isEmpty()){
            view?.showError("Username should not be empty")
        } else if(password.isEmpty()) {
            view?.showError("Password should not be empty")
        }else if(userName.isEmpty() && password.isEmpty()){
            view?.showError("Username and password should not be empty")
        }else {
            if(isUserRegistered(userName,password)){
                loginSession.saveUsername(userName)
                loginRouter.goToMainPage()
            }else{
                view?.showError("Do Registration")
            }
        }
    }

    override fun isUserRegistered(userName: String, password: String): Boolean {
        return userModel.getUserData(userName,password)!= null

    }



}