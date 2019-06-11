package com.scoproject.rijksmuseum.data.network

import com.scoproject.rijksmuseum.data.response.ArtObject
import com.scoproject.rijksmuseum.data.response.DetailArtObject
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
interface RijksService {
    @GET(RestConstant.collections)
    fun getCollectionsAsync(): Deferred<ArtObject.Response>

    @GET(RestConstant.getDetailCollection)
    fun getDetailCollectionAsync(@Path("objectNumber") objectNumber: String): Deferred<DetailArtObject.Response>

}