package com.digitaleg.pinterestdownloadmanager.home

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.digitaleg.pinterestdownloadmanager.R
import com.digitaleg.pinterestdownloadmanager.databinding.HomeItemBinding
import com.digitaleg.pinterestdownloadmanager.home.model.HomeCardModel


/**
 * Created by Mohamed Elshafey on 4/18/2018.
 */
class HomeCardAdapter(var movies: ArrayList<HomeCardModel>) : BaseAdapter() {

    fun updateData(movies: ArrayList<HomeCardModel>?) {
        this.movies = movies!!;
        super.notifyDataSetChanged()
    }

    @SuppressLint("ViewHolder")
    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val inflater: LayoutInflater = LayoutInflater.from(viewGroup!!.context)
        val binding: HomeItemBinding = DataBindingUtil.inflate(inflater, R.layout.home_item, viewGroup, false)

        val movie = movies[i]

        binding.homeItemViewModel = HomeItemViewModel(movie)

        return binding.root
    }

    override fun getItem(i: Int): Any {
        return 0
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return movies.size
    }

}