package com.scoproject.rijksmuseum.features.profile.domain

import android.app.Activity
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.profile.presentation.ProfileContract
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ProfileRouter @Inject constructor(val screenRouter: ScreenRouter
                                        , val context: Activity) : ProfileContract.Router{

}