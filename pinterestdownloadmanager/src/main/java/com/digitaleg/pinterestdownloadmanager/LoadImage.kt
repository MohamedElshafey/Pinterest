package com.digitaleg.pinterestdownloadmanager

import android.graphics.Bitmap
import android.os.AsyncTask
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class LoadImage(url: String, loadObserver: LoadObserver) : LoadType {

    override fun cancel() {
        loadImageAsync.cancel(true);
    }

    var loadImageAsync: LoadImageAsync

    init {

        loadImageAsync = LoadImageAsync(url, loadObserver)

        loadImageAsync.execute()

    }

    class LoadImageAsync(private val url: String, private val loadObserver: LoadObserver) : AsyncTask<Void, Void, Bitmap>() {

        override fun doInBackground(vararg params: Void?): Bitmap? {
            return try {
                val bitmap = Picasso.get()
                        .load(url)
                        .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                        .get()

                CacheManager.lruCache.put(url, bitmap)

                bitmap
            } catch (e: Exception) {
                null
            }
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            if (result != null) {
                loadObserver.loaded(result)
            } else {
                loadObserver.error("Cannot load bitmap")
            }
        }

    }

}