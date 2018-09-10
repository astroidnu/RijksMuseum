package com.scoproject.rijksmuseum.features.login.domain

import android.app.Activity
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.login.presentation.LoginContract
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
class LoginRouter @Inject constructor(val screenRouter: ScreenRouter
                                      ,val mContext: Activity) : LoginContract.Router{

}