package com.scoproject.rijksmuseum.data.repository

import com.scoproject.rijksmuseum.data.response.ArtObject
import io.reactivex.Observable

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
interface RijskRepository {
    fun getCollections() : Observable<ArtObject.Response>
}