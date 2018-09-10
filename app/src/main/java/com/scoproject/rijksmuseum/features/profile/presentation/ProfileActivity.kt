package com.scoproject.rijksmuseum.features.profile.presentation

import android.os.Bundle
import android.widget.LinearLayout
import com.scoproject.rijksmuseum.R
import com.scoproject.rijksmuseum.presentation.BaseNavigationDrawerActivity
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ProfileActivity : BaseNavigationDrawerActivity(), ProfileContract.View {
    @Inject
    lateinit var mPresenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        val container: LinearLayout = findViewById(R.id.content_frame)
        inflater.inflate(R.layout.activity_profile, container)
        mPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}