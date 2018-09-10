package com.scoproject.rijksmuseum.features.listart.usecase

import com.scoproject.rijksmuseum.data.repository.RijskRepository
import com.scoproject.rijksmuseum.data.response.ArtObject
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class ListArtInteractor @Inject constructor(private val rijksRepository: RijskRepository) : ListArtUseCase {
    override fun getCollections(): Observable<ArtObject.Response> {
        return rijksRepository.getCollections().flatMap {
            Observable.just(it)
        }
    }

}