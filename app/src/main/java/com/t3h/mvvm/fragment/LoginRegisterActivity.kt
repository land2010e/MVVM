package com.t3h.mvvm.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.t3h.mvvm.BaseActivity
import com.t3h.mvvm.BaseFragment
import com.t3h.mvvm.R
import com.t3h.mvvm.fragment.store.ExternalStoreFragment

class LoginRegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
        openFirstLoinFragment()


    }
    private fun openFirstLoinFragment(){
        //them fragment vao
        //lay fragmentManager
        val manager = supportFragmentManager
        //mo transaction
        val transaction = manager.beginTransaction()
        //them fragment vao
        val fr = LoginFragment()
        transaction.add(
            R.id.content, fr,
            LoginFragment.javaClass.name
        )
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun openRegister(username: String) {
        //budle giong intent
//        val bunle = Bundle()
//        bunle.putString("USERNAME", username)
        val fr = RegisterFragment()
        //dua bunle vao fragment
//        fr.arguments = bunle
        fr.username = username

        supportFragmentManager
            .beginTransaction()
            //animation
            .setCustomAnimations(
                R.anim.open_eneter, R.anim.open_exit,
                R.anim.back_open, R.anim.back_exit
            )
            .hide(
                supportFragmentManager.findFragmentByTag(
                    LoginFragment.javaClass.name
                )!!
            )
            .add(
                R.id.content,
                fr,
                RegisterFragment::javaClass.name
            )
//            .setCustomAnimations()
            .addToBackStack(null)
            .commit()
    }

    fun findFragmentVisible(): Fragment? {
        for (fragment in supportFragmentManager.fragments) {
            if (fragment != null && fragment.isVisible) {
                return fragment
            }
        }
        return null
    }

    fun openStore() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.open_eneter, R.anim.open_exit,
                R.anim.back_open, R.anim.back_exit
            )
            .hide(
                findFragmentVisible()!!
            )
            .add(
                R.id.content,
                StoreFragment(),
                StoreFragment::javaClass.name
            )
            .addToBackStack(null)
            .commit()
    }

    private fun openFirstExternalStoreFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.content, ExternalStoreFragment(),
                ExternalStoreFragment::javaClass.name
            )
            .commit()
    }
    fun openExternalStoreFragment() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.open_eneter, R.anim.open_exit,
                R.anim.back_open, R.anim.back_exit
            )
            .hide(
                findFragmentVisible()!!
            )
            .add(
                R.id.content, ExternalStoreFragment(),
                ExternalStoreFragment::javaClass.name
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val fr = findFragmentVisible()
        if (fr != null){
            (fr as BaseFragment).onBackPress()
        }else {
            backRoot()
        }
    }
}