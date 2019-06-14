package com.scoproject.rijksmuseum

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.scoproject.base.data.model.UserModel
import com.scoproject.rijksmuseum.data.response.ArtObject
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtContract
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtPresenter
import com.scoproject.rijksmuseum.features.listart.usecase.ListArtUseCase
import com.scoproject.rijksmuseum.features.registration.domain.RegistrationRouter
import com.scoproject.rijksmuseum.util.TestSchedulerProvider
import com.tunaikumobile.base.data.session.LoginSession
import org.junit.After
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
    private val mLoginSession: LoginSession = mock()
    private val mUserModel: UserModel = mock()
    private val mUseCase: ListArtUseCase = mock()
    private val mLoginRouter: RegistrationRouter = mock()

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
        val response : ArtObject.Response = mock()

        doReturn(Observable.just(response))
                .`when`(mUseCase)
                .getCollectionsAsync()
        mListArtPresenter.getCollections()
        mTestScheduler.triggerActions()
        verify(mView).showLoading()
        verify(mView).setupAdapter(response)
        verify(mView).hideLoading()
    }

    @After
    fun tearDown(){
        mListArtPresenter.detachView()
    }
}