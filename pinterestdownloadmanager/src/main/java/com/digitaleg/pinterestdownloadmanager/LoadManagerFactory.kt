package com.digitaleg.pinterestdownloadmanager

import android.content.Context

class LoadManagerFactory(context: Context?, fileType: FileType, url: String, loadObserver: LoadObserver) {

    init {

        if (fileType == FileType.IMAGE) {

            LoadImage(url, loadObserver)

        } else if (fileType == FileType.JSON) {

            if (context == null)
                throw java.lang.Exception("queue must be not null")

            LoadJSON(context, url, loadObserver)
        }
    }
}