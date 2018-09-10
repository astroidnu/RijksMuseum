package com.scoproject.rijksmuseum.external

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class Helper {

    fun isUsenameValid(userName: String) : Boolean {
        return userName.isNotEmpty()
    }

    fun isPasswordValid(password: String) : Boolean {
        return password.isNotEmpty()
    }
}