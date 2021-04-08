package com.t3h.mvvm.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.t3h.mvvm.databinding.FragmentLoginBinding

class LoginFragment : Fragment, View.OnClickListener {
    companion object {
        val TAG = LoginFragment.javaClass.simpleName
    }

    private var binding: FragmentLoginBinding? = null

    constructor() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate.........")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //tao view
        Log.d(TAG, "onCreateView.................")
        binding = FragmentLoginBinding.inflate(
            inflater, container, false
        )
        binding!!.tvRegister.setOnClickListener(this)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onPause() {
        Log.d(TAG, "onPause.........")
        super.onPause()
    }

    override fun onResume() {
        Log.d(TAG, "onResume.........")
        super.onResume()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView.........")
        binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy.........")
        super.onDestroy()
    }

    override fun onClick(v: View) {
        //activity: la activity chua fragment
        (activity as LoginRegisterActivity)
            .openRegister(
                binding!!.edtUsername.text.toString()
            )
    }

    fun updateUsername(username: String) {
        binding!!.edtUsername.setText(username)
    }


}