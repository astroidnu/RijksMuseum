package com.scoproject.base.presentation.ui.presenter

import com.scoproject.base.presentation.ui.view.BaseView
import java.lang.ref.WeakReference


/**
 * Created by ibnumuzzakkir on 08/05/18.
 * Android Engineer
 * SCO Project
 */

open class BasePresenter<V : BaseView> :
        IBasePresenter<V> {

    private var weakReference: WeakReference<V>? = null

    override fun attachView(view: V) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
            view.setPresenter(this)
        }
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }

    val view: V?
        get() = weakReference?.get()

    private val isViewAttached: Boolean
        get() = weakReference != null && weakReference!!.get() != null
}