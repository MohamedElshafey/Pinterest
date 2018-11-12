package com.digitaleg.pinterestdownloadmanager

import android.app.Application
import com.digitaleg.pinterestdownloadmanager.network.DaggerNetworkComponent
import com.digitaleg.pinterestdownloadmanager.network.NetworkComponent
import com.digitaleg.pinterestdownloadmanager.network.NetworkModule

/**
 * Created by Mohamed Elshafey on 4/16/2018.
 */
class App : Application() {
    var networkComponent: NetworkComponent? = null

    override fun onCreate() {
        super.onCreate()

        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(NetworkModule("http://pastebin.com"))
                .build()
    }
}