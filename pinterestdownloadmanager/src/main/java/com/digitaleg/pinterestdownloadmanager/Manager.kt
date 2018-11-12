package com.digitaleg.pinterestdownloadmanager

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.AsyncTask
import com.squareup.picasso.Picasso

class Manager<T, E>(val link: String, val fileType: FileType, val loadObserver: LoadObserver<Bitmap, String>) {

    init {
        if (fileType.equals(FileType.IMAGE)) {

            val asyncTask: AsyncTask<Void, Void, Bitmap> = @SuppressLint("StaticFieldLeak")
            object : AsyncTask<Void, Void, Bitmap>() {
                override fun doInBackground(vararg params: Void?): Bitmap? {
                    try {
                        val bitmap = Picasso.get().load(link).get()
                        return bitmap
                    } catch (e: Exception) {
                        return null
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

            asyncTask.execute()
        }

    }
}