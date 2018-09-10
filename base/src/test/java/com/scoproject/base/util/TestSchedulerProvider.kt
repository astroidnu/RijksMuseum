package com.scoproject.base.util

import com.scoproject.base.external.scheduler.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Created by ibnumuzzakkir on 09/12/17.
 * Android Engineer
 * SCO Project
 */
class TestSchedulerProvider constructor(private val testScheduler: TestScheduler) : SchedulerProvider {
    override fun ui(): Scheduler = testScheduler
    override fun computation(): Scheduler = testScheduler
    override fun io(): Scheduler = testScheduler
    override fun mainThread(): Scheduler = testScheduler
}