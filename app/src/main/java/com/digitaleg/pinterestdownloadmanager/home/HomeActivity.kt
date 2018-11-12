package com.digitaleg.pinterestdownloadmanager.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.digitaleg.pinterestdownloadmanager.App
import com.digitaleg.pinterestdownloadmanager.R
import com.digitaleg.pinterestdownloadmanager.databinding.ActivityHomeBinding
import retrofit2.Retrofit
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).networkComponent?.inject(this)


        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)

        binding.homeVM = HomeViewModel(retrofit)
    }
}
