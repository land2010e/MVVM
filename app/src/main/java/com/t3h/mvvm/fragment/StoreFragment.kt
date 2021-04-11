package com.t3h.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.t3h.mvvm.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {
    private var binding: FragmentStoreBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreBinding.inflate(
            inflater, container, false
        )
        binding!!.tab.setupWithViewPager(binding!!.vp)
        binding!!.vp.adapter = StoreAdapter(
            childFragmentManager
        )
        return binding!!.root
    }
}