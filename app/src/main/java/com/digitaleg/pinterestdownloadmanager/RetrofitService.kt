package com.digitaleg.pinterestdownloadmanager

import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Mohamed Elshafey on 4/18/2018.
 */
interface RetrofitService {

    @GET("raw/wgkJgazE")
    fun listCards(): Observable<ArrayList<HomeCardModel>>

}