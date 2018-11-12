package com.digitaleg.pinterestdownloadmanager

import android.app.Application
import com.digitaleg.pinterestdownloadmanager.dagger.DaggerNetworkComponent
import com.digitaleg.pinterestdownloadmanager.dagger.NetworkComponent
import com.digitaleg.pinterestdownloadmanager.dagger.NetworkModule

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