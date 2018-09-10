package com.scoproject.rijksmuseum

import com.scoproject.rijksmuseum.external.Helper
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class HelperTest {
    private  lateinit var mHelper : Helper

    @Before
    fun setUp() {
        mHelper = Helper()
    }

    @Test
    fun userNameMustbeValid() {
        assertEquals(mHelper.isUsenameValid("ibnu"), true)
        assertEquals(mHelper.isUsenameValid("jono"), true)
        assertEquals(mHelper.isUsenameValid("joniiiiii123"), true)
    }

    @Test
    fun userNameIsNotValid() {
        assertEquals(mHelper.isUsenameValid(""), false)
    }



    @Test
    fun passwordMustBeValid() {
        assertEquals(mHelper.isPasswordValid("passworrd"), true)
        assertEquals(mHelper.isPasswordValid("test123"), true)
        assertEquals(mHelper.isPasswordValid("ibnu123"), true)
    }

    @Test
    fun passwordIsNotValid() {
        assertEquals(mHelper.isPasswordValid(""), false)
    }


}