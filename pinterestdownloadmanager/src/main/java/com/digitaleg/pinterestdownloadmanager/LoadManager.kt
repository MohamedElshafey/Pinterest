package com.digitaleg.pinterestdownloadmanager

import android.content.Context

class LoadManager(url: String, fileType: FileType, context: Context?, loadObserver: LoadObserver) {

    private var loadManagerFactory: LoadManagerFactory? = null

    init {

        val cachedObject = CacheManager.lruCache.get(url)

        if (cachedObject != null) {

            loadObserver.loaded(cachedObject)

        } else {

            loadManagerFactory = LoadManagerFactory(context, fileType, url, loadObserver)

        }
    }

    fun cancelLoad() {
        loadManagerFactory!!.cancel()
    }
}