package com.digitaleg.pinterestdownloadmanager

import android.util.LruCache

object CacheManager {

    private const val cacheSize = 8 * 1024 * 1024

    internal var lruCache = LruCache<String, Any>(cacheSize)
}
