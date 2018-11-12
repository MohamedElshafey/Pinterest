package com.digitaleg.pinterestdownloadmanager

interface LoadObserver {

    fun loaded(t: Any)

    fun error(e: Any)
}