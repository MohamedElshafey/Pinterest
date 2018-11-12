package com.digitaleg.pinterestdownloadmanager.home.card

import android.databinding.BaseObservable
import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel

class HomeCardViewModel(homeCardModel: HomeCardModel) : BaseObservable() {

    val imageUrl: String = {
        try {
            homeCardModel.urls!!.regular!!
        } catch (e: Exception) {
            ""
        }
    }.invoke()

    val profilePicUrl: String = {
        try {
            homeCardModel.user!!.profileImage!!.medium!!
        } catch (e: Exception) {
            ""
        }
    }.invoke()


}