package com.scoproject.rijksmuseum.features.listart.usecase

import com.scoproject.rijksmuseum.data.network.RijksService
import com.scoproject.rijksmuseum.data.response.ArtObject
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtInteractor @Inject constructor(private val rijksService: RijksService) : ListArtUseCase {
    override suspend fun getCollections(): ArtObject.Response {
        return rijksService.getCollectionsAsync().await()
    }
}