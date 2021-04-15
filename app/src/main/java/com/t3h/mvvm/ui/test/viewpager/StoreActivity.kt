package com.t3h.mvvm.ui.test.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.t3h.mvvm.R
import com.t3h.mvvm.databinding.ActivityStoreBinding
import com.t3h.mvvm.ui.test.fragment.StoreAdapter

class StoreActivity:AppCompatActivity(){
    private var binding:ActivityStoreBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_store
        )

        binding!!.tab.setupWithViewPager(binding!!.vp)
        binding!!.vp.adapter = StoreAdapter(supportFragmentManager)
    }
}