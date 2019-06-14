package com.scoproject.base.external

import kotlin.coroutines.CoroutineContext

interface ContextCoroutineProvider {
    fun uiDispatcher(): CoroutineContext
    fun bgDispatcher(): CoroutineContext
}