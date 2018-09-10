package com.scoproject.rijksmuseum.features.detailart.usecase

import com.scoproject.rijksmuseum.data.response.DetailArtObject
import io.reactivex.Observable

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
interface DetailArtUseCase {
    fun getDetailCollection(objectNumber: String) : Observable<DetailArtObject.Response>
}