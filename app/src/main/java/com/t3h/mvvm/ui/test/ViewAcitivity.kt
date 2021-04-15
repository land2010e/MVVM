package com.t3h.mvvm.ui.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.t3h.mvvm.R
import com.t3h.mvvm.databinding.AcitivityViewBinding

class ViewAcitivity : AppCompatActivity() {
    private lateinit var binding: AcitivityViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.acitivity_view
        )
        binding.tvV.setText(
            intent.getStringExtra("CONTENT")
        )
    }
}