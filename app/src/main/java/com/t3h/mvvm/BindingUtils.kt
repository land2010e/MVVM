package com.t3h.mvvm

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingUtils {
    //ta ca cac phuong thuc trong nay deu la static

    //muon su dung custom databing thi: apply plugin: 'kotlin-kapt' trong build.gradlew
    @JvmStatic
    @BindingAdapter("loadImageInt")
    fun loadImageInt(iv: ImageView, imageId: Int) {
        Glide.with(iv)
            .load(imageId)
            .placeholder(R.drawable.ao_dai1)
            .error(R.drawable.ao_dai1)
            .into(iv)
    }

    @JvmStatic
    @BindingAdapter("setText")
    fun setText(tv: TextView, value: String?) {
        tv.setText(value)
    }

}