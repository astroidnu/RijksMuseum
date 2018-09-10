package com.scoproject.rijksmuseum.features.listart.domain

import android.app.Activity
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.features.detailart.presentation.DetailArtActivity.Companion.TAG_OBJECT_NUMBER
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtContract
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtRouter @Inject constructor(val screenRouter: ScreenRouter
                                      , val context: Activity) : ListArtContract.Router{
    override fun navigateToDetailCollection(objectNumber: String) {
        screenRouter.getScreenIntent(context, ScreenRouter.ActivityScreen.DetailCollectionScreen)
                ?.apply {
                    putExtra(TAG_OBJECT_NUMBER, objectNumber)
                }
                ?.run { context.startActivity(this) }
    }

}