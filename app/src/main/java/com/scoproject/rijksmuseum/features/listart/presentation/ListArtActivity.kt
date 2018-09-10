package com.scoproject.rijksmuseum.features.listart.presentation

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.scoproject.base.external.extensions.showToast
import com.scoproject.base.presentation.ui.adapter.setUp
import com.scoproject.rijksmuseum.R
import com.scoproject.rijksmuseum.data.response.ArtObject
import com.scoproject.rijksmuseum.features.listart.domain.ListArtRouter
import com.scoproject.rijksmuseum.presentation.BaseNavigationDrawerActivity
import kotlinx.android.synthetic.main.activity_list_art.*
import kotlinx.android.synthetic.main.item_list_art.view.*
import javax.inject.Inject


/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtActivity : BaseNavigationDrawerActivity(), ListArtContract.View {
    @Inject
    lateinit var mPresenter: ListArtPresenter

    @Inject
    lateinit var mRouter : ListArtRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val inflater = layoutInflater
        val container: LinearLayout = findViewById(R.id.content_frame)
        inflater.inflate(R.layout.activity_list_art, container)
        mPresenter.attachView(this)
        mPresenter.getCollections()
    }

    override fun setupAdapter(data:ArtObject.Response) {
        rvListArt?.setUp(data.data!!, R.layout.item_list_art, { it ->
            val objectNumber = it.objectNumber
            tvTitleArt.text = it.title
            Glide.with(this)
                    .load(it.headerImage?.url)
                    .into(ivThumbArt)

            llItemArt.setOnClickListener {
                objectNumber?.let{
                    mRouter.navigateToDetailCollection(it)
                }
            }
        })
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun showLoading() {
        avLoading.visibility = View.VISIBLE
        rvListArt.visibility = View.GONE
    }

    override fun hideLoading() {
        rvListArt.visibility = View.VISIBLE
        avLoading.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}