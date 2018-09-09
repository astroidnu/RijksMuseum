package com.scoproject.base.presentation.ui.presenter

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.base.presentation.ui.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * Created by ibnumuzzakkir on 08/05/18.
 * Android Engineer
 * SCO Project
 */

open class BasePresenter<V : BaseView> constructor(var scheduler : SchedulerProvider): IBasePresenter<V> {


    private val mCompositeDisposable by lazy {
        CompositeDisposable()
    }

    private var weakReference: WeakReference<V>? = null

    override fun attachView(view: V) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
            view.setPresenter(this)
        }
    }

    protected fun addDisposable(subscription: Disposable) {
        mCompositeDisposable.add(subscription)
    }

    protected fun stopDisposable(){
        mCompositeDisposable.dispose()
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
        mCompositeDisposable.clear()
    }

    private fun dispose() {
        if (mCompositeDisposable.size() > 0) {
            mCompositeDisposable.clear()
        }
    }

    val view: V?
        get() = weakReference?.get()

    private val isViewAttached: Boolean
        get() = weakReference != null && weakReference!!.get() != null
}