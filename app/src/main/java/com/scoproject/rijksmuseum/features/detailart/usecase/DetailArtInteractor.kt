package com.scoproject.rijksmuseum.features.detailart.usecase

import com.scoproject.rijksmuseum.data.network.RijksService
import com.scoproject.rijksmuseum.features.detailart.data.vo.DetailArtVO
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class DetailArtInteractor @Inject constructor(private val rijksService: RijksService) : DetailArtUseCase {
    override suspend fun getDetailCollection(objectNumber: String): DetailArtVO {
        val data = rijksService.getDetailCollectionAsync(objectNumber).await().artObject
        return DetailArtVO(data?.webImage?.url ?: "", data?.label?.description ?: "")
    }
}