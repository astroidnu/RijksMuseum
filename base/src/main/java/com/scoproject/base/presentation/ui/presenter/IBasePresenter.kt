package  com.scoproject.base.presentation.ui.presenter

import com.scoproject.base.presentation.ui.view.BaseView

/**
 * Created by ibnumuzzakkir on 08/05/18.
 * Android Engineer
 * SCO Project
 */

interface IBasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}