package com.digitaleg.pinterestdownloadmanager.home

import android.databinding.BaseObservable
import android.util.Log
import com.digitaleg.pinterestdownloadmanager.RetrofitService
import com.digitaleg.pinterestdownloadmanager.home.card.HomeCardAdapter
import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class HomeViewModel(retrofit: Retrofit) : BaseObservable() {

    val TAG = this.toString()

    var disposable: Disposable? = null

    var cardList: ArrayList<HomeCardModel>? = null

    var cardAdapter: HomeCardAdapter? = null

    init {
        val retrofitService = retrofit.create(RetrofitService::class.java)

        val observable = retrofitService.listCards()
        disposable = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    if (it != null) {
                        cardList = it
                        cardList!!.addAll(it)
                        cardList!!.addAll(it)
                        cardList!!.addAll(it)
                        cardList!!.addAll(it)

                        cardAdapter = HomeCardAdapter(cardList!!)
                        this@HomeViewModel.notifyChange()
                    }

                    Log.d(TAG, " Success getting listCards , list: $it")

                }, {
                    Log.d(TAG, " Error getting listCards , cause: $it")
                })
    }

}