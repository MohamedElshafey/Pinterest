package com.digitaleg.pinterestdownloadmanager.home.card

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
class HomeCardAdapter(var cardList: List<HomeCardModel>) : BaseAdapter() {

    fun updateData(cards: List<HomeCardModel>?) {
        cardList.toMutableSet().clear()
        cardList = cards!!
        notifyDataSetChanged()
    }

    @SuppressLint("ViewHolder")
    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val inflater: LayoutInflater = LayoutInflater.from(viewGroup!!.context)
        val binding: HomeItemBinding = DataBindingUtil.inflate(inflater, R.layout.home_item, viewGroup, false)

        val card = cardList[i]

        binding.homeItemViewModel = HomeCardViewModel(card)

        return binding.root
    }

    override fun getItem(i: Int): Any {
        return 0
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return cardList.size
    }

}