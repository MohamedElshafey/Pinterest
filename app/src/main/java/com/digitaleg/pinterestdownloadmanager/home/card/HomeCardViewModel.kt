package com.digitaleg.pinterestdownloadmanager.home.card

import android.databinding.BaseObservable
import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel

class HomeCardViewModel(homeCardModel: HomeCardModel) : BaseObservable() {

    var TAG = this@HomeCardViewModel.toString()

    val imageUrl = homeCardModel.urls!!.regular!!

}