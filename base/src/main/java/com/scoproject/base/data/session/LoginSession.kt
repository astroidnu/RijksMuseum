package com.tunaikumobile.base.data.session

import android.app.Application
import android.content.Context
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 11/10/17.
 * Android Engineer
 * SCO Project
 */
class LoginSession @Inject constructor(application: Application) {
    var isLogin: Boolean = false

    object TAG {
        const val PREF_TOKEN = "token"
    }

    var pref = Pref(application)

    inner class Pref internal constructor(val application: Application) : BaseSharedPreferences() {
        init {
            check()
        }

        override fun getApplicationContext(): Context {
            return application
        }

        override fun getUserProfileName(): String {
            return "user_session"
        }
    }


    fun getLoginToken(): String {
        return pref._getString(TAG.PREF_TOKEN, "")!!
    }

    fun saveToken(token: String) {
        pref._setString(TAG.PREF_TOKEN, token)
        isLogin = true
    }
}