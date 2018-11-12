package com.digitaleg.pinterestdownloadmanager

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class LoadJSON(context: Context, url: String, loadObserver: LoadObserver) : LoadType {

    override fun cancel() {
        queue.cancelAll(stringRequest)
    }

    private var queue: RequestQueue = Volley.newRequestQueue(context)
    var stringRequest: StringRequest

    init {

        stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    if (response != null) {
                        CacheManager.lruCache.put(url, response)
                        loadObserver.loaded(response)
                    } else {
                        loadObserver.error("Null response")
                    }
                },
                Response.ErrorListener {
                    loadObserver.error("Cannot get response, cause : $it")
                })

        queue.add(stringRequest)
    }

}