package com.scoproject.rijksmuseum.features.detailart.presentation

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.scoproject.base.external.extensions.showToast
import com.scoproject.base.presentation.ui.activity.BaseActivity
import com.scoproject.rijksmuseum.R
import kotlinx.android.synthetic.main.activity_detail_art.*
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class DetailArtActivity : BaseActivity(), DetailArtContract.View {
    companion object {
        const val TAG_OBJECT_NUMBER = "object_number"
    }

    @Inject
    lateinit var mPresenter: DetailArtPresenter

    override fun getLayoutId(): Int {
        return R.layout.activity_detail_art
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        if (bundle != null) {
            val objectNumber = bundle.getString(TAG_OBJECT_NUMBER)
            mPresenter.getDetailCollection(objectNumber)
        }
    }

    override fun setupContent(imageUrl: String?, artDesc: String?) {
        loadImage(imageUrl)
        tvDescriptionArt.text = artDesc
    }

    private fun loadImage(url: String?) {
        Glide.with(this)
                .load(url)
                .into(ivDetailArt)
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun showLoading() {
        svDetailArt.visibility = View.GONE
        avLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        svDetailArt.visibility = View.VISIBLE
        avLoading.visibility = View.GONE
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}