package com.scoproject.base.external.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */

/**
 * Inflating Layout for RecyclerView
 * */

infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)


/**
 * Show Toast
 * */

fun Context.showToast(msg : String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

/**
 * Checking network state
 * @return boolean
 * */

fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}