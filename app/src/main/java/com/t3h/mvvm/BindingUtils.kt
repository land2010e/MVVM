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
    @BindingAdapter("loadImageLink")
    fun loadImageInt(iv: ImageView, link: String?) {
        if (link == null) {
            Glide.with(iv)
                .load(R.drawable.ao_dai1)
                .placeholder(R.drawable.ao_dai1)
                .error(R.drawable.ao_dai1)
                .into(iv)
            return
        }
        Glide.with(iv)
            .load(link)
            .placeholder(R.drawable.ao_dai1)
            .error(R.drawable.ao_dai1)
            .into(iv)
    }

    @JvmStatic
    @BindingAdapter("setText")
    fun setText(tv: TextView, value: String?) {
        tv.setText(value)
    }
    @JvmStatic
    @BindingAdapter("setImageFile")
    fun setImageFile(iv:ImageView, isFile: Boolean) {
        if (isFile){
            iv.setImageResource(R.drawable.baseline_insert_drive_file_orange_500_48dp)
        }else {
            iv.setImageResource(R.drawable.baseline_folder_orange_500_48dp)
        }
    }

}