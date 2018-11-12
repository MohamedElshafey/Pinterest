package com.digitaleg.pinterestdownloadmanager

import android.content.Context

class LoadManagerFactory(context: Context?, fileType: FileType, url: String, loadObserver: LoadObserver) {

    private lateinit var loadTypeInterface: LoadType

    init {

        if (fileType == FileType.IMAGE) {

            loadTypeInterface = LoadImage(url, loadObserver)

        } else if (fileType == FileType.JSON) {

            if (context == null)
                throw Exception("queue must be not null")

            loadTypeInterface = LoadJSON(context, url, loadObserver)
        }
    }

    fun cancel() {
        loadTypeInterface.cancel()
    }

}