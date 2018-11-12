package com.digitaleg.pinterestdownloadmanager

interface LoadObserver<T, E> {

    fun loaded(t: T)

    fun error(e: E)
}