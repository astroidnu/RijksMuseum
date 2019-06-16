package com.scoproject.rijksmuseum

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.scoproject.rijksmuseum.data.response.ArtObject
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtContract
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtPresenter
import com.scoproject.rijksmuseum.features.listart.usecase.ListArtUseCase
import com.scoproject.rijksmuseum.util.TestContextCoroutineProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtPresenterTest {
    private lateinit var mListArtPresenter : ListArtPresenter
    private val mView: ListArtContract.View = mock()
    private lateinit var mHelper : Helper
    private val mUseCase: ListArtUseCase = mock()
    private lateinit var testDispatcher: TestContextCoroutineProvider

    @Before
    fun `Setup`() {
        mHelper = Helper()
        testDispatcher = TestContextCoroutineProvider()
        mListArtPresenter = ListArtPresenter(mUseCase, testDispatcher)
        mListArtPresenter.attachView(mView)
    }

    @Test
    fun `Get List Art Should Be Success`() = runBlocking {
        val response : ArtObject.Response = mock()
        launch(Dispatchers.Unconfined) {
            doReturn(response)
                    .`when`(mUseCase)
                    .getCollectionsAsync()

            Assert.assertEquals(mUseCase.getCollectionsAsync(), response)
        }
        mListArtPresenter.getCollections()

        verify(mView).showLoading()
        verify(mView).setupAdapter(mUseCase.getCollectionsAsync())
        verify(mView).hideLoading()
    }

    @Test
    fun `Error Not Handle When Get List Art`() = runBlocking {
        val errorResponse = Throwable()

        launch(Dispatchers.Unconfined) {
            doReturn(errorResponse)
                    .`when`(mUseCase)
                    .getCollectionsAsync()
        }

        mListArtPresenter.getCollections()

        verify(mView).showLoading()
        verify(mView).showError("Something went wrong! Please try again.")
        verify(mView).hideLoading()
    }

    @After
    fun `TearDown`() {
        mListArtPresenter.detachView()
    }
}