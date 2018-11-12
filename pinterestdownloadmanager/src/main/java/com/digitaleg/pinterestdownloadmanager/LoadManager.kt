package com.digitaleg.pinterestdownloadmanager

import android.content.Context

class LoadManager(url: String, fileType: FileType, context: Context?, loadObserver: LoadObserver) {

    init {

        val cachedObject = CacheManager.lruCache.get(url)

        if (cachedObject != null) {

            loadObserver.loaded(cachedObject)

        } else {

            LoadManagerFactory(context, fileType, url, loadObserver)

        }
    }
}