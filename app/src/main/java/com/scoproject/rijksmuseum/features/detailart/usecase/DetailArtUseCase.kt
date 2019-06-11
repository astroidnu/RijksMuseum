package com.scoproject.rijksmuseum.features.detailart.usecase

import com.scoproject.rijksmuseum.features.detailart.data.vo.DetailArtVO

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
interface DetailArtUseCase {
    suspend fun getDetailCollection(objectNumber: String): DetailArtVO
}