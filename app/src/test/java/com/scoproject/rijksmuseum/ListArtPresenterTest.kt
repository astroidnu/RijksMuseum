package com.scoproject.rijksmuseum

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.scoproject.rijksmuseum.data.response.ArtObject
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtContract
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtPresenter
import com.scoproject.rijksmuseum.features.listart.usecase.ListArtUseCase
import com.scoproject.rijksmuseum.util.TestSchedulerProvider
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtPresenterTest {
    private lateinit var mListArtPresenter: ListArtPresenter
    private lateinit var mTestScheduler: TestScheduler
    private val mView: ListArtContract.View = mock()
    private lateinit var mHelper: Helper
    private val mUseCase: ListArtUseCase = mock()

    @Before
    fun setUp() {
        mHelper = Helper()
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        mListArtPresenter = ListArtPresenter(mUseCase, testSchedulerProvider)
        mListArtPresenter.attachView(mView)
    }

    @Test
    fun getCollectionShouldReturnSuccess() {
        val response: ArtObject.Response = mock()

        doReturn(Observable.just(response))
                .`when`(mUseCase)
                .getCollections()
        mListArtPresenter.getCollections()
        mTestScheduler.triggerActions()
        verify(mView).showLoading()
        verify(mView).setupAdapter(response)
        verify(mView).hideLoading()
    }

    @After
    fun tearDown() {
        mListArtPresenter.detachView()
    }
}