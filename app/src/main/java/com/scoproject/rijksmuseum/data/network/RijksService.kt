    package com.scoproject.rijksmuseum.data.network

    import com.scoproject.rijksmuseum.data.response.ArtObject
    import io.reactivex.Observable
    import retrofit2.http.GET

    /**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
interface RijksService {
        @GET(RestConstant.collections)
        fun getCollections() : Observable<ArtObject.Response>
}