package com.scoproject.rijksmuseum.features.listart.usecase

import com.scoproject.rijksmuseum.data.response.ArtObject
import io.reactivex.Observable

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
interface ListArtUseCase {
    fun getCollections() : Observable<ArtObject.Response>
}