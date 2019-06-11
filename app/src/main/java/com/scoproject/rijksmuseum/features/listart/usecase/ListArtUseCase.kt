package com.scoproject.rijksmuseum.features.listart.usecase

import com.scoproject.rijksmuseum.data.response.ArtObject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
interface ListArtUseCase {
    suspend fun getCollectionsAsync(): ArtObject.Response
}