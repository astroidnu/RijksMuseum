package com.scoproject.rijksmuseum.data.repository

import com.scoproject.base.external.scheduler.SchedulerProvider
import com.scoproject.rijksmuseum.data.network.RijksService
import com.scoproject.rijksmuseum.data.response.ArtObject
import com.scoproject.rijksmuseum.data.response.DetailArtObject
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class RijskDataStore @Inject constructor(private val service : RijksService, private val scheduler : SchedulerProvider) : RijskRepository {

    override fun getDetailCollection(objectNumber: String): Observable<DetailArtObject.Response> {
        return service.getDetailCollection(objectNumber)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.mainThread())
    }

    override fun getCollections(): Observable<ArtObject.Response> {
        return service.getCollections()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.mainThread())
    }
}