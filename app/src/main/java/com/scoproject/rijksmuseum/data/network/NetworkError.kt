package com.scoproject.rijksmuseum.data.network

import retrofit2.HttpException
import java.io.IOException


/**
 * Created by ibnumuzzakkir on 8/31/17.
 * Android Engineer
 * SCO Project
 */
class NetworkError(var err: Throwable) : Throwable() {

    companion object {
        private var DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again."
        const val NETWORK_ERROR_MESSAGE = "No Internet Connection!"
    }

    fun getErrorMessage(): String {
        if (err is IOException) {
            return NETWORK_ERROR_MESSAGE
        }

        if (getHttpErrorCode()!! == 404 || getHttpErrorCode()!! >= 500) {
            DEFAULT_ERROR_MESSAGE = "Server sedang bermasalah"
        }

        return DEFAULT_ERROR_MESSAGE
    }

    /**
     * Get Http Error Code
     * @Return 200,300,400,etc
     * */

    fun getHttpErrorCode(): Int? {
        return when (err) {
            is IOException -> return 0
            is HttpException -> (err as HttpException).code()
            else -> 0
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as NetworkError?

        return err == that!!.err
    }

    override fun hashCode(): Int {
        return err.hashCode()
    }

}