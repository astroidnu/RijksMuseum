package com.scoproject.base

import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.base.presentation.ui.view.BaseView
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class BasePresenterTest{
    private lateinit var basePresenter: BasePresenter<BaseView>
    private val view: BaseView = mock()

    @Before
    fun setUp() {
        basePresenter = BasePresenter()
    }

    @Test
    fun attachView() {
        basePresenter.attachView(view)
        verify(view).setPresenter(basePresenter)
    }

    @After
    fun tearDown(){
        basePresenter.detachView()
    }
}