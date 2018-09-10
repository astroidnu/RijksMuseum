package com.scoproject.base

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.scoproject.base.presentation.ui.presenter.BasePresenter
import com.scoproject.base.presentation.ui.view.BaseView
import com.scoproject.base.util.TestSchedulerProvider
import io.reactivex.schedulers.TestScheduler
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
        val testSchedulerProvider = TestSchedulerProvider(TestScheduler())
        basePresenter = BasePresenter(testSchedulerProvider)
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