package com.digitaleg.pinterestdownloadmanager.home

import android.databinding.BaseObservable
import android.graphics.Bitmap
import android.util.Log
import com.digitaleg.pinterestdownloadmanager.FileType
import com.digitaleg.pinterestdownloadmanager.LoadObserver
import com.digitaleg.pinterestdownloadmanager.Manager
import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel

class HomeItemViewModel(homeCardModel: HomeCardModel) : BaseObservable() {

    var coverBitmap: Bitmap? = null
    var TAG = this@HomeItemViewModel.toString()

    init {
        Manager<String, Bitmap>(homeCardModel.urls!!.regular!!, FileType.IMAGE,
                object : LoadObserver<Bitmap, String> {
                    override fun loaded(t: Bitmap) {
                        coverBitmap = t
                        this@HomeItemViewModel.notifyChange()
                    }

                    override fun error(e: String) {
                        Log.d(TAG, "cannot get image, cause: $e")
                    }

                })
    }


}