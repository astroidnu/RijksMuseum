package com.scoproject.rijksmuseum.features.listart.domain

import android.app.Activity
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtContract
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtRouter @Inject constructor(val screenRouter: ScreenRouter
                                      , val context: Activity) : ListArtContract.Router{

}