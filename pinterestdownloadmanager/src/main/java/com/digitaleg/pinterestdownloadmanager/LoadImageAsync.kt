package com.digitaleg.pinterestdownloadmanager

import android.graphics.Bitmap
import android.os.AsyncTask
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso


class LoadImageAsync(val url: String, val loadObserver: LoadObserver) : AsyncTask<Void, Void, Bitmap>() {

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