package com.t3h.mvvm

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

//phai laf final
    fun backRoot() {
        super.onBackPressed()
    }
}