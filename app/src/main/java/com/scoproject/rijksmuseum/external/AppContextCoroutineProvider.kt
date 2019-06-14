package com.scoproject.rijksmuseum.external

import com.scoproject.base.external.ContextCoroutineProvider
import kotlinx.coroutines.Dispatchers

class AppContextCoroutineProvider : ContextCoroutineProvider {
    override fun uiDispatcher() = Dispatchers.Main
    override fun bgDispatcher() = Dispatchers.IO
}