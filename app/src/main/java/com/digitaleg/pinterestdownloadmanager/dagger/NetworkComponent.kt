package com.digitaleg.pinterestdownloadmanager.dagger

import com.digitaleg.pinterestdownloadmanager.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Mohamed Elshafey on 4/16/2018.
 */

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(activity: HomeActivity)

}