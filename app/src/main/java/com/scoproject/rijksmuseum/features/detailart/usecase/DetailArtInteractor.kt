package com.scoproject.rijksmuseum.features.detailart.usecase

import com.scoproject.rijksmuseum.data.repository.RijskRepository
import com.scoproject.rijksmuseum.data.response.DetailArtObject
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class DetailArtInteractor @Inject constructor(private val rijksRepository: RijskRepository) : DetailArtUseCase {
    override fun getDetailCollection(objectNumber: String): Observable<DetailArtObject.Response> {
        return rijksRepository.getDetailCollection(objectNumber).flatMap {
            Observable.just(it)
        }
    }

}