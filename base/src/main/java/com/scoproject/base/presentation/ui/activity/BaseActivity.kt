package com.scoproject.base.presentation.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.base.presentation.ui.view.BaseView
import dagger.android.AndroidInjection

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var presenter: BasePresenter<*>? = null

    /**
     * This function replace onCreate as main function run in activity
     * Auto Dependency Injection
     * @param Bundle
     * */

    abstract fun onActivityReady(savedInstanceState: Bundle?)

    /**
     * Getting Layout ID from activity
     * */

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        //Auto DI
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onActivityReady(savedInstanceState)
    }


    /**
     * Setting up base presenter based on view
     * */

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }


}