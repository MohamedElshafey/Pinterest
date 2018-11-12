package com.digitaleg.pinterestdownloadmanager.home

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.widget.AbsListView
import android.widget.GridView
import android.widget.ImageView
import com.digitaleg.pinterestdownloadmanager.FileType
import com.digitaleg.pinterestdownloadmanager.LoadManager
import com.digitaleg.pinterestdownloadmanager.LoadObserver
import com.digitaleg.pinterestdownloadmanager.home.card.HomeCardAdapter
import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel

class HomeBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl", requireAll = true)
        fun setBitmap(imageView: ImageView, imageUrl: String?) {
            if (imageUrl != null) {
                LoadManager(imageUrl, FileType.IMAGE, imageView.context,
                        object : LoadObserver {
                            override fun loaded(t: Any) {
                                if (t is Bitmap)
                                    imageView.setImageBitmap(t)
                            }

                            override fun error(e: Any) {
                                Log.d("SET_BITMAP", "cannot get image, cause: $e")
                            }
                        })

            }
        }

        @JvmStatic
        @BindingAdapter("gridViewToRefresh", "listToRefresh", requireAll = false)
        fun swipeListener(swipeRefreshLayout: SwipeRefreshLayout, gridView: GridView?, cardList: ArrayList<HomeCardModel>?) {
            swipeRefreshLayout.setOnRefreshListener {

                gridView!!.adapter = null
                val toIndex = {
                    if (cardList!!.size >= 10)
                        10
                    else
                        cardList.size
                }.invoke()

                val miniList: MutableList<HomeCardModel> = cardList!!.subList(0, toIndex)
                gridView.adapter = HomeCardAdapter(miniList)
                swipeRefreshLayout.isRefreshing = false
            }
        }

        @JvmStatic
        @BindingAdapter("adapter", "cardList", requireAll = true)
        fun addGridAdapter(gridView: GridView, adapter: HomeCardAdapter?, cardList: ArrayList<HomeCardModel>?) {
            if (gridView.adapter == null)
                gridView.adapter = adapter
        }

        @JvmStatic
        @BindingAdapter("loadMore")
        fun loadMoreScroll(gridView: GridView, loadMoreInterface: LoadMore) {
            var page = 1
            gridView.setOnScrollListener(object : AbsListView.OnScrollListener {
                override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                    val lastItem = firstVisibleItem + visibleItemCount;
                    if (lastItem == totalItemCount) {
                        page++
                        loadMoreInterface.load(page)
                    }
                }

                override fun onScrollStateChanged(view: AbsListView?, i: Int) {
                }
            })
        }

    }
}