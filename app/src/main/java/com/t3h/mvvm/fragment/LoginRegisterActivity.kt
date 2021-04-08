package com.t3h.mvvm.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.t3h.mvvm.R

class LoginRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
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
            .hide(
                supportFragmentManager.findFragmentByTag(
                    LoginFragment.javaClass.name
                )!!
            )
            .add(
                R.id.content,
                fr,
                ""
            )
//            .setCustomAnimations()
            .addToBackStack(null)
            .commit()
    }
}