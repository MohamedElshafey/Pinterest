package com.digitaleg.pinterestdownloadmanager.home

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.widget.GridView
import android.widget.ImageView
import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel

class BindingAdapter {

    companion object {


        @JvmStatic
        @BindingAdapter("bitmap", requireAll = true)
        fun setBitmap(imageView: ImageView, bitmap: Bitmap?) {
            imageView.setImageBitmap(bitmap)
        }

//        @JvmStatic
////        @BindingAdapter("recyclerView")
////        fun swipeListener(swipeRefreshLayout: SwipeRefreshLayout, recyclerView: RecyclerView) {
////            swipeRefreshLayout.setOnRefreshListener {
////
////            }
////        }

        @JvmStatic
        @BindingAdapter("adapter", "cardList", requireAll = true)
        fun addGridAdapter(gridView: GridView, adapter: HomeCardAdapter?, cardList: ArrayList<HomeCardModel>?) {
            if (gridView.adapter == null)
                gridView.adapter = adapter

//            adapter.updateData(cardList)
        }

//        @JvmStatic
//        @BindingAdapter("loadMore", requireAll = true)
//        fun endlessScroll(gridView: GridView, loadMoreInterface: LoadMore) {
//            var page = 1
//            gridView.setOnScrollListener(object : AbsListView.OnScrollListener {
//                override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
//                    try {
//                        if (!(gridView.lastVisiblePosition != gridView.adapter!!.count - 1
//                                        || gridView.getChildAt(gridView.childCount - 1).bottom > gridView.height)) {
//                            page++
//                            loadMoreInterface.load(page)
//                        }
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//                }
//
//                override fun onScrollStateChanged(view: AbsListView?, i: Int) {
//                }
//            })
//        }

    }
}