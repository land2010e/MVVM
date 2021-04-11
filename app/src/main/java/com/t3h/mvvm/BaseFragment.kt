package com.t3h.mvvm

import androidx.fragment.app.Fragment

open class BaseFragment:Fragment(){

    open fun onBackPress(){
        if (activity != null){
            (activity as BaseActivity).backRoot()
        }
    }
}