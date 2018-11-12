package com.digitaleg.pinterestdownloadmanager.home

import android.databinding.BaseObservable
import android.util.Log
import com.digitaleg.pinterestdownloadmanager.network.RetrofitService
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

    val loadMore = object : LoadMore {
        override fun load(page: Int) {
            if (cardList == null)
                return

            val toIndex = {
                if (cardList!!.size > page * 10)
                    page * 10
                else
                    cardList!!.size
            }.invoke()

            if (page * 10 < cardList!!.size) {
                val miniList: MutableList<HomeCardModel> = cardList!!.subList(0, toIndex)
                cardAdapter!!.updateData(miniList)
            }
        }
    }

    init {
        val retrofitService = retrofit.create(RetrofitService::class.java)

        val observable = retrofitService.listCards()
        disposable = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    if (it != null) {
                        cardList = it

                        val toIndex = {
                            if (cardList!!.size >= 10)
                                10
                            else
                                cardList!!.size
                        }.invoke()

                        val miniList: MutableList<HomeCardModel> = cardList!!.subList(0, toIndex)

                        cardAdapter = HomeCardAdapter(miniList)
                        this@HomeViewModel.notifyChange()
                    }

                    Log.d(TAG, " Success getting listCards , list: $it")

                }, {
                    Log.d(TAG, " Error getting listCards , cause: $it")
                })
    }

}